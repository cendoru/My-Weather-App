package com.cendoru.weatherapp.service;

import org.springframework.stereotype.Service;
import com.cendoru.weatherapp.client.OpenWeatherClient;
import com.cendoru.weatherapp.client.OpenWeatherResponse;
import com.cendoru.weatherapp.dto.WeatherDTO;

@Service
public class WeatherService {
    
    private final OpenWeatherClient client;

    public WeatherService(OpenWeatherClient client) {
        this.client = client;
    }

    public WeatherDTO getWeather(String location) {
        OpenWeatherResponse response = client.fetchWeather(location);

        WeatherDTO dto = new WeatherDTO();
        dto.setLocation(response.getName());
        dto.setDescription(response.getWeather().get(0).getDescription());
        dto.setTemperature(response.getMain().getTemp());
        dto.setFeelsLike(response.getMain().getHumidity());
        dto.setHumidity(response.getMain().getHumidity());
        dto.setIcon(response.getWeather().get(0).getIcon());

        return dto;
    }
}
