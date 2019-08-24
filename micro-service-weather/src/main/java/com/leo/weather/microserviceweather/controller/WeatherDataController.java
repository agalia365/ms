package com.leo.weather.microserviceweather.controller;

import com.leo.weather.microserviceweather.model.WeatherResponse;
import com.leo.weather.microserviceweather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
