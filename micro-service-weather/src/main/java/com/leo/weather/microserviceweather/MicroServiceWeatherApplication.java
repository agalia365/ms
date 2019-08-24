package com.leo.weather.microserviceweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MicroServiceWeatherApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceWeatherApplication.class, args);
    }

}
