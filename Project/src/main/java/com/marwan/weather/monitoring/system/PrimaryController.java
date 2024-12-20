package com.marwan.weather.monitoring.system;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label windSpeedLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label weatherAlertLabel;

    @FXML
    private TextField cityTextField; // Input field for city name

    private final WeatherDataFetcher weatherDataFetcher = new WeatherDataFetcher();

    @FXML
    private void handleSearch() {
        String city = cityTextField.getText();

        if (city == null || city.isEmpty()) {
            weatherAlertLabel.setText("Please enter a city name.");
            return;

        }

        try {
            // Fetch weather data for the entered city
            weatherDataFetcher.fetchWeatherData(city);
            UserPreferencesManager preferences = UserPreferencesManager.getInstance();
            String temperatureUnit = preferences.getTemperatureUnit();
            String windSpeedUnit = preferences.getWindSpeedUnit(); // Km/h or M/h

            // After fetching, update the UI (you could pass the results directly)
            if (temperatureUnit.equals("°C")) {
                // If Celsius, show the temperature as is
                temperatureLabel.setText(WeatherDataFactory.getLastTemperature() + "°C");
            } else {
                // If Fahrenheit, convert from Celsius to Fahrenheit
                double temperatureInCelsius =Double.parseDouble(WeatherDataFactory.getLastTemperature()); 
                double temperatureInFahrenheit = (temperatureInCelsius * 9 / 5) + 32;
                temperatureLabel.setText(String.valueOf(temperatureInFahrenheit+"°F"));
            }

                // Update wind speed based on the unit preference
            if (windSpeedUnit.equals("Km/h")) {
                // If Km/h, show the wind speed as is
                windSpeedLabel.setText(WeatherDataFactory.getLastWindSpeed()+"Km/h");
            } else if (windSpeedUnit.equals("M/h")) {
                // If Mph, convert from Km/h to Mph
                double windSpeedInKmH = Double.parseDouble(WeatherDataFactory.getLastWindSpeed());
                double windSpeedInMph = windSpeedInKmH * 0.621371;
                windSpeedLabel.setText(String.valueOf(windSpeedInMph+"M/h"));
            }

// Update humidity without any conversion since it usually stays in percentage
            humidityLabel.setText(WeatherDataFactory.getLastHumidity());
        } catch (Exception e) {
            weatherAlertLabel.setText("Failed to fetch weather data.");
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void initialize() {
        //temperatureLabel.setText();
        //windSpeedLabel.setText(preferences.getWindSpeedUnit());

        WeatherAlert alert = WeatherAlertFactory.createAlert("storm");
        weatherAlertLabel.setText(alert.generateAlertMessage());

    }
}
