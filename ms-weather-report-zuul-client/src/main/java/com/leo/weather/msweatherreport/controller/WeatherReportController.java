package com.leo.weather.msweatherreport.controller;

import com.leo.weather.msweatherreport.client.DataClient;
import com.leo.weather.msweatherreport.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityName/{cityName}")
    public ModelAndView getDataByCityName(@PathVariable String cityName, Model model) throws Exception {
        model.addAttribute("title", "Leo 的天气预报");
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", dataClient.cityList());
        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        ModelAndView mv = new ModelAndView("weather/report", "reportModel", model);
        return mv;
    }

}
