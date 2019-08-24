package com.leo.weather.msweathercity.service.impl;

import com.leo.weather.msweathercity.model.City;
import com.leo.weather.msweathercity.model.County;
import com.leo.weather.msweathercity.service.CityDataService;
import com.leo.weather.msweathercity.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<County> getCityList() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = bf.readLine()) != null) {
            buffer.append(line);
        }
        bf.close();
        // xml to java
        City city = (City) XmlBuilder.xmlStrToOjb(City.class, buffer.toString());
        return city.getCountyList();
    }
}
