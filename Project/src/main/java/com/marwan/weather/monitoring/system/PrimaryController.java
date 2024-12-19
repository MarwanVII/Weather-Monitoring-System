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
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    public void initialize() {
        // Get user preferences
        UserPreferencesManager preferences = UserPreferencesManager.getInstance();

        // Display preferences on the primary page
        temperatureLabel.setText(preferences.getTemperatureUnit());
        windSpeedLabel.setText(preferences.getWindSpeedUnit());
    }
}
