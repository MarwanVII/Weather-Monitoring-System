package com.marwan.weather.monitoring.system;
    // Concrete class for Temperature
public class Temperature implements WeatherDataType {
    private double value;

    public Temperature(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
