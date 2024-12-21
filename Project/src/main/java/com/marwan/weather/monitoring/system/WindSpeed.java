package com.marwan.weather.monitoring.system;
    // Concrete class for WindSpeed
public class WindSpeed implements WeatherDataType {
    private double value;

    public WindSpeed(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
