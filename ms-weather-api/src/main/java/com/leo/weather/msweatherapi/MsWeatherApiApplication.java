package com.leo.weather.msweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsWeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherApiApplication.class, args);
    }

}
