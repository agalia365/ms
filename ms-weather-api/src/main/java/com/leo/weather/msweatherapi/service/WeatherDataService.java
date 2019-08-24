package com.leo.weather.msweatherapi.service;


import com.leo.weather.msweatherapi.model.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityName(String cityName);

}
