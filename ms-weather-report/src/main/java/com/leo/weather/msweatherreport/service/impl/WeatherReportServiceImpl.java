package com.leo.weather.msweatherreport.service.impl;

import com.leo.weather.msweatherreport.model.Weather;
import com.leo.weather.msweatherreport.service.WeatherReportService;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityName(String cityName) {
        // TODO

        Weather data = new Weather();
        data.setCity("上海");
        data.setWendu("37");
        data.setGanmao("XXXXXXdafsadlkf提醒");
        return data;
    }
}
