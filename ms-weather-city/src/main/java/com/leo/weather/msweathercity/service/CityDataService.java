package com.leo.weather.msweathercity.service;

import com.leo.weather.msweathercity.model.County;

import java.util.List;

public interface CityDataService {

    List<County> getCityList() throws Exception;
}
