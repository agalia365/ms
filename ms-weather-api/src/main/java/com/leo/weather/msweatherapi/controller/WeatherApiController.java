package com.leo.weather.msweatherapi.controller;

import com.leo.weather.msweatherapi.model.WeatherResponse;
import com.leo.weather.msweatherapi.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherApiController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
