package com.leo.weather.msweatherreport.client;

import com.leo.weather.msweatherreport.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-weather-api")
public interface WeatherApiClient {

    @GetMapping("/weather/cityName/{cityName}")
    WeatherResponse getDataByCityName(@PathVariable String cityName);
}
