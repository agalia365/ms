package com.leo.weather.msweatherreport.service;

import com.leo.weather.msweatherreport.model.Weather;

public interface WeatherReportService {

    public Weather getDataByCityName(String cityName);
}
