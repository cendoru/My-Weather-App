package com.cendoru.weatherapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cendoru.weatherapp.dto.LocationDTO;
import com.cendoru.weatherapp.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {
    
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDTO> searchLocations(@RequestParam String q) {
        System.out.println("Searching location: " + q);
        return locationService.search(q);
    }

    @GetMapping("/ping")
    public String ping() {
        return "LocationController detected";
    }
    
}
