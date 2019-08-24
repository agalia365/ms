package com.leo.weather.microserviceweather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.weather.microserviceweather.service.WeatherDataService;
import com.leo.weather.microserviceweather.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {


    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final long TIME_OUT = 500;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void syncDateByCityId(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        saveWeatherData(uri);
    }

    /**
     * save weather data into redis
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ResponseEntity<String> resEntity = restTemplate.getForEntity(uri, String.class);
        if (resEntity.getStatusCode().equals(HttpStatus.OK)) {
            String strBody = resEntity.getBody();
            logger.info(strBody);
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        WeatherResponse weatherResponse = getWeatherResponse(uri);

        return weatherResponse;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        WeatherResponse weatherResponse = getWeatherResponse(uri);
        return weatherResponse;
    }

    private WeatherResponse getWeatherResponse(String uri) {
        WeatherResponse weatherResponse = null;
        String strBody = null;
        // 先查缓存，
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(uri)) {
            logger.info("has Redis data");
            strBody = ops.get(uri);
        } else {
            logger.info("Does not have data, look up from internet.");
            ResponseEntity<String> resEntity = restTemplate.getForEntity(uri, String.class);
            strBody = resEntity.getBody();

            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            weatherResponse = new WeatherResponse();
            weatherResponse.setStatus(0);
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
