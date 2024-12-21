package com.marwan.weather.monitoring.system;

    // Concrete class for Humidity
    public class Humidity implements WeatherDataType {
        private int value;

        public Humidity(int value) {
            this.value = value;
        }

    @Override
    public double getValue() {
        return value;
    }

        
    }
