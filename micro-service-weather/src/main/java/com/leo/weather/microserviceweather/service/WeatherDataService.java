package com.leo.weather.microserviceweather.service;


import com.leo.weather.microserviceweather.model.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    void syncDateByCityId(String cityId);

}
