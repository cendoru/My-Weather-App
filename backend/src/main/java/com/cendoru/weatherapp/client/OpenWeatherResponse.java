package com.cendoru.weatherapp.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherResponse {
    private String name;
    private Main main;
    private List<Weather> weather;

    // getters & setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    // nested classes

    public static class Main {
        private double temp;
        public double getTemp() {
            return temp;
        }
        public void setTemp(double temp) {
            this.temp = temp;
        }

        @JsonProperty("feels_like")
        private double feelsLike;
        public double getFeelsLike() {
            return feelsLike;
        }
        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        private int humidity;
        public int getHumidity() {
            return humidity;
        }
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

    }

    public static class Weather {
        private String description;
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        private String icon;
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
