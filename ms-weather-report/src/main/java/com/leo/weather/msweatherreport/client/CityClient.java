package com.leo.weather.msweatherreport.client;

import com.leo.weather.msweatherreport.model.County;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("ms-weather-city")
public interface CityClient {

    @GetMapping("/weather/cityList")
    List<County> cityList();
}
