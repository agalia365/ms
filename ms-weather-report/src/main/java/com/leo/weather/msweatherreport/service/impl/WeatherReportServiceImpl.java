package com.leo.weather.msweatherreport.service.impl;

import com.leo.weather.msweatherreport.client.WeatherApiClient;
import com.leo.weather.msweatherreport.model.Weather;
import com.leo.weather.msweatherreport.model.WeatherResponse;
import com.leo.weather.msweatherreport.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse response = weatherApiClient.getDataByCityName(cityName);
        return response.getData();
    }
}
