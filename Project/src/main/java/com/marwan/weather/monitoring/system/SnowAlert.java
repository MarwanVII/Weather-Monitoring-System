package com.marwan.weather.monitoring.system;

public class SnowAlert implements WeatherAlert {
    @Override
    public String generateAlertMessage() {
        return "Snow Alert: Drive carefully and watch for icy conditions.";
    }
}
