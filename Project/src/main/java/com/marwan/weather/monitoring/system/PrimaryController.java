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

            // After fetching, update the UI (you could pass the results directly)
            temperatureLabel.setText(WeatherDataFactory.getLastTemperature());
            windSpeedLabel.setText(WeatherDataFactory.getLastWindSpeed());
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
        UserPreferencesManager preferences = UserPreferencesManager.getInstance();
        temperatureLabel.setText(preferences.getTemperatureUnit());
        windSpeedLabel.setText(preferences.getWindSpeedUnit());
        
        WeatherAlert alert = WeatherAlertFactory.createAlert("storm");
        weatherAlertLabel.setText(alert.generateAlertMessage());
        
        
    }
}
