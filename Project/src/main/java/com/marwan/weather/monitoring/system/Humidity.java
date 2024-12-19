/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marwan.weather.monitoring.system;

/**
 *
 * @author AL_fajar
 */
    // Concrete class for Humidity
    public class Humidity implements WeatherDataType {
        private int value;

        public Humidity(int value) {
            this.value = value;
        }

        @Override
        public void display() {
            System.out.println("Humidity: " + value + "%");
        }
    }
