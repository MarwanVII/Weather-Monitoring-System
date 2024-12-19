/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marwan.weather.monitoring.system;

/**
 *
 * @author Ahmed Saad
 */
public class WeatherDataFactory {
        public static final String TEMPERATURE = "temperature";
        public static final String WINDSPEED = "windspeed";
        public static final String HUMIDITY = "humidity";
        
        public static WeatherDataType createWeatherData(String type, double value) {
            switch (type.toLowerCase()) {
                case "temperature":
                    return new Temperature(value);
                case "windspeed":
                    return new WindSpeed(value);
                case "humidity":
                    return new Humidity((int) value); // Cast to int for humidity
                default:
                    throw new IllegalArgumentException("Invalid weather data type: " + type);
            }
        }
    }
