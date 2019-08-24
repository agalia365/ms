package com.leo.weather.microserviceweather.service.impl;

import com.leo.weather.microserviceweather.model.Weather;
import com.leo.weather.microserviceweather.model.WeatherResponse;
import com.leo.weather.microserviceweather.service.WeatherDataService;
import com.leo.weather.microserviceweather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse response = weatherDataService.getDataByCityName(cityName);
        return response.getData();
    }
}
