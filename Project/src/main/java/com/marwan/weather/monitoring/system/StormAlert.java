package com.marwan.weather.monitoring.system;


public class StormAlert implements WeatherAlert{
    @Override
    public String generateAlertMessage() {
        return "Severe Storm Alert: Stay indoors and avoid unnecessary travel.";
    }
}
