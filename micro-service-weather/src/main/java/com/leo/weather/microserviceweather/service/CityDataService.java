package com.leo.weather.microserviceweather.service;

import com.leo.weather.microserviceweather.model.County;

import java.util.List;

public interface CityDataService {

    List<County> listCity() throws Exception;
}
