package com.leo.weather.msweatherapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.weather.msweatherapi.model.WeatherResponse;
import com.leo.weather.msweatherapi.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        WeatherResponse weatherResponse = getWeatherResponse(uri);
        return weatherResponse;
    }

    private WeatherResponse getWeatherResponse(String uri) {
        WeatherResponse weatherResponse = null;
        String strBody = null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(uri)) {
            logger.info("has Redis data");
            strBody = ops.get(uri);
        } else {
            logger.info("Redis does not have data");
           throw new RuntimeException("Redis does not have data");
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
