package com.cendoru.weatherapp.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherClient {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public OpenWeatherClient(RestTemplate restTemplate,
                            @Value("${openweather.api.url}") String apiUrl,
                            @Value("${openweather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }
    public OpenWeatherResponse fetchWeather(String location) {
        String url = apiUrl
                    +  "?q=" + location
                    + "&appid=" + apiKey
                    + "&units=metric";

        return restTemplate.getForObject(url, OpenWeatherResponse.class);
    }
}
