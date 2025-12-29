package com.cendoru.weatherapp.dto;

public class LocationDTO {
    private String name;
    private String country;
    private double lat;
    private double lon;

    public String getName() { return name; }
    public String getCountry() { return country; }
    public double getLat() { return lat; }
    public double getLon() { return lon; }

    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setLat(double lat) { this.lat = lat; }
    public void setLon(double lon) { this.lon = lon; }
}
