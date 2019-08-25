package com.leo.weather.msweatherreport.service.impl;

import com.leo.weather.msweatherreport.client.DataClient;
import com.leo.weather.msweatherreport.model.Weather;
import com.leo.weather.msweatherreport.model.WeatherResponse;
import com.leo.weather.msweatherreport.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    private Logger logger = LoggerFactory.getLogger(WeatherReportServiceImpl.class);
    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse response = dataClient.getDataByCityName(cityName);
        System.out.println(response);
        return response.getData();
    }
}
