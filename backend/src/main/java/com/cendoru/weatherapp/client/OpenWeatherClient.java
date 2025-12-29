package com.cendoru.weatherapp.client;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cendoru.weatherapp.dto.LocationDTO;

@Component
public class OpenWeatherClient {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;
    private final String apiLocationUrl;

    public OpenWeatherClient(RestTemplate restTemplate,
                            @Value("${openweather.api.url}") String apiUrl,
                            @Value("${openweather.api.key}") String apiKey,
                            @Value("${openweather.api.location}") String apiLocationUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.apiLocationUrl = apiLocationUrl;
    }

    public List<LocationDTO> fetchLocations(String location) {
        try {
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
            String url = apiLocationUrl
                        +  "?q=" + encodedLocation
                        + "&limit=5"
                        + "&appid=" + apiKey;
            System.out.println("Fetching URL: " + url);

            ResponseEntity<List<LocationDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {}
            );

            if (response == null) {
                throw new RuntimeException("No locations found");
            } 
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public OpenWeatherResponse fetchWeather(double lon, double lat) {
        String url = apiUrl
                    +  "?lat=" + lat
                    + "&lon=" + lon
                    + "&appid=" + apiKey
                    + "&units=metric";

        return restTemplate.getForObject(url, OpenWeatherResponse.class);
    }
}
