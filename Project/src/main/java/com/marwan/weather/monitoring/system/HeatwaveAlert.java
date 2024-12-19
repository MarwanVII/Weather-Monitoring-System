package com.marwan.weather.monitoring.system;

public class HeatwaveAlert implements WeatherAlert{
    @Override
    public String generateAlertMessage() {
        return "Heatwave Alert: Stay hydrated and avoid prolonged exposure to the sun.";
    }
}
