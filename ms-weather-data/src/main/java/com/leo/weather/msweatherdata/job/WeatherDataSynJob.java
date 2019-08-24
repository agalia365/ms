package com.leo.weather.msweatherdata.job;

import com.leo.weather.msweatherdata.model.County;
import com.leo.weather.msweatherdata.service.WeatherDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


public class WeatherDataSynJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(WeatherDataSynJob.class);


    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather data synchronized start.");

        // 获取城市列表 TODO
        try {
            List<County> countryList = new ArrayList<>();
            County county1 = new County();
            county1.setName("上海");
            countryList.add(county1);
            if (countryList == null) {
                return;
            }
            for (County county : countryList) {
                logger.info("Weather data synchronized with ....." + county.getName());
                weatherDataService.syncWeatherDateByCityName(county.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error during ......", e);
        }
        logger.info("Weather data synchronized end.");
    }
}