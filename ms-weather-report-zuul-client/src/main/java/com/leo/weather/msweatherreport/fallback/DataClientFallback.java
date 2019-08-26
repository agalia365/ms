package com.leo.weather.msweatherreport.fallback;

import com.leo.weather.msweatherreport.client.DataClient;
import com.leo.weather.msweatherreport.model.County;
import com.leo.weather.msweatherreport.model.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<County> cityList() {
        List<County> countyList = new ArrayList<>();
        County county = new County();
        county.setName("北京");
        countyList.add(county);

        County county2 = new County();
        county2.setName("上海");
        countyList.add(county2);

        return countyList;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {

        return null;
    }
}
