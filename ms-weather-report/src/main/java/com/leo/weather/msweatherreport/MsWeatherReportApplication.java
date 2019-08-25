package com.leo.weather.msweatherreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsWeatherReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherReportApplication.class, args);
    }

}
