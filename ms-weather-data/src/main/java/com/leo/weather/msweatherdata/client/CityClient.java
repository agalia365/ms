package com.leo.weather.msweatherdata.client;

import com.leo.weather.msweatherdata.model.County;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("ms-weather-city")
public interface CityClient {

    @GetMapping("/weather/cityList")
    public List<County> cityList();
}
