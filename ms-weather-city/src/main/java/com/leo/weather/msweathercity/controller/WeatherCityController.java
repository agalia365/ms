package com.leo.weather.msweathercity.controller;

import com.leo.weather.msweathercity.model.County;
import com.leo.weather.msweathercity.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherCityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityList")
    public List<County> cityList() throws Exception {
        return cityDataService.getCityList();
    }
}
