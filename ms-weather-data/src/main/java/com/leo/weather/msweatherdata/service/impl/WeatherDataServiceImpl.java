package com.leo.weather.msweatherdata.service.impl;

import com.leo.weather.msweatherdata.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public void syncWeatherDateByCityName(String cityName) {
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



}
