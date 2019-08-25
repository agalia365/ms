package com.leo.weather.msweatherreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsWeatherReportZuulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherReportZuulClientApplication.class, args);
    }

}
