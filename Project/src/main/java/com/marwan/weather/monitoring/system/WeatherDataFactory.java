package com.marwan.weather.monitoring.system;

public class WeatherDataFactory {
    public static final String TEMPERATURE = "temperature";
    public static final String WINDSPEED = "windspeed";
    public static final String HUMIDITY = "humidity";

    private static WeatherDataType lastTemperature;
    private static WeatherDataType lastWindSpeed;
    private static WeatherDataType lastHumidity;

    public static WeatherDataType createWeatherData(String type, double value) {
        switch (type.toLowerCase()) {
            case TEMPERATURE:
                lastTemperature = new Temperature(value);
                return lastTemperature;

            case WINDSPEED:
                lastWindSpeed = new WindSpeed(value);
                return lastWindSpeed;

            case HUMIDITY:
                lastHumidity = new Humidity((int) value); // Cast to int for humidity
                return lastHumidity;

            default:
                throw new IllegalArgumentException("Invalid weather data type: " + type);
        }
    }
    public static String getLastTemperature() {
        return lastTemperature != null
                ? String.valueOf(lastTemperature.getValue())
                : "--";
    }

    public static String getLastWindSpeed() {
        return lastWindSpeed != null
                ? String.valueOf(lastWindSpeed.getValue())
                : "--";
    }

    public static String getLastHumidity() {
        return lastHumidity != null
                ? lastHumidity.getValue() + " %"
                : "--";
    }
}
