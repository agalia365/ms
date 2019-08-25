package com.leo.weather.msweathergatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MsWeatherGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWeatherGatewayZuulApplication.class, args);
    }

}
