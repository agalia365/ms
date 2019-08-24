package com.leo.weather.microserviceweather.service;

import com.leo.weather.microserviceweather.model.Weather;

public interface WeatherReportService {

    public Weather getDataByCityName(String cityName);
}
