package com.cendoru.weatherapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cendoru.weatherapp.dto.WeatherDTO;
import com.cendoru.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("path")
    public WeatherDTO getWeather(@RequestParam String location) {
        return service.getWeather(location);
    }
}
