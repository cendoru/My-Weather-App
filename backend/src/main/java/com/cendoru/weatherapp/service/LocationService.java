package com.cendoru.weatherapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cendoru.weatherapp.client.OpenWeatherClient;
import com.cendoru.weatherapp.dto.LocationDTO;

@Service
public class LocationService {
    private final OpenWeatherClient client;

    public LocationService(OpenWeatherClient client) {
        this.client = client;
    }

    public List<LocationDTO> search(String query) {
        System.out.println("LocationService received: " + query);
        return client.fetchLocations(query);
    }
}
