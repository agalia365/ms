package com.leo.weather.msweatherdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsWeatherDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherDataApplication.class, args);
    }

}
