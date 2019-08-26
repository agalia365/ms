package com.leo.weather.msweatherreport.client;

import com.leo.weather.msweatherreport.fallback.DataClientFallback;
import com.leo.weather.msweatherreport.model.County;
import com.leo.weather.msweatherreport.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "ms-weather-gateway-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    @GetMapping("/city/weather/cityList")
    List<County> cityList();

    @GetMapping("/api/weather/cityName/{cityName}")
    WeatherResponse getDataByCityName(@PathVariable String cityName);
}
