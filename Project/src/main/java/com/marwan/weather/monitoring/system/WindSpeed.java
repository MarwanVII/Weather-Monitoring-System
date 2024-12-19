/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marwan.weather.monitoring.system;

/**
 *
 * @author Ahmed Saad
 */
    // Concrete class for WindSpeed
    public class WindSpeed implements WeatherDataType {
        private double value;

        public WindSpeed(double value) {
            this.value = value;
        }

        @Override
        public void display() {
            System.out.println("Wind Speed: " + value + " km/h");
        }
    }
