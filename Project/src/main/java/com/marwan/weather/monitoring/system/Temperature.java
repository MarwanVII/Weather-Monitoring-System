/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marwan.weather.monitoring.system;

/**
 *
 * @author Ahmed Saad
 */
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
