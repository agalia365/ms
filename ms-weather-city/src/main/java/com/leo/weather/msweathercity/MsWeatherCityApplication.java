package com.leo.weather.msweathercity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsWeatherCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherCityApplication.class, args);
    }

}
