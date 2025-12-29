package com.cendoru.weatherapp.dto;

public class WeatherDTO {
    // for actual response
    private String location;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private String description;
    private String icon;

    public String getLocation() { return location; }
    public double getTemperature() { return temperature; }
    public double getFeelsLike() { return feelsLike; }
    public int getHumidity() { return humidity; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
    
    public void setLocation(String location) { this.location = location; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setFeelsLike(double feelsLike) { this.feelsLike = feelsLike; }
    public void setHumidity(int humidity) { this.humidity = humidity; }
    public void setDescription(String description) { this.description = description; }
    public void setIcon(String icon) { this.icon = icon; }
}
