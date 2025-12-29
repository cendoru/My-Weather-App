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

    @GetMapping("/weather")
    public WeatherDTO getWeather(
            @RequestParam double lat,
            @RequestParam double lon) {
        WeatherDTO dto = service.getWeather(lon, lat);
        System.out.println("Returning weather: " + dto);
        return dto;
    }
}
