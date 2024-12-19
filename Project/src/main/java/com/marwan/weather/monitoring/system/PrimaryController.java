package com.marwan.weather.monitoring.system;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {
    
    @FXML
    private Label temperatureLabel;

    @FXML
    private Label windSpeedLabel;
    
    @FXML
    private Label weatherAlertLabel;

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
