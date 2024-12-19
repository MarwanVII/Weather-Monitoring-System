package com.marwan.weather.monitoring.system;

public class WeatherAlertFactory {
    public static WeatherAlert createAlert(String condition) {
        switch (condition.toLowerCase()) {
            case "storm":
                return new StormAlert();
            case "heatwave":
                return new HeatwaveAlert();
            case "snow":
                return new SnowAlert();
            default:
                throw new IllegalArgumentException("Unknown weather condition: " + condition);
        }
    }
}
