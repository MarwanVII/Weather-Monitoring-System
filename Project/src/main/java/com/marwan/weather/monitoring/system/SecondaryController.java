package com.marwan.weather.monitoring.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SecondaryController implements Initializable {
     @FXML
    private ComboBox<String> tempList;

    @FXML
    private ComboBox<String> windList;

    @FXML
    private void switchToPrimary() throws IOException {
        
        UserPreferencesManager preferences = UserPreferencesManager.getInstance();
        preferences.setTemperatureUnit(tempList.getValue());
        preferences.setWindSpeedUnit(windList.getValue());
        
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      String [] TemperatureMeasurmentUnit = {"°C" , "°F"}; 
      String [] WindSpeedMeasurmentUnit = {"Km/h" , "M/h"};
      tempList.getItems().addAll(TemperatureMeasurmentUnit);
      windList.getItems().addAll(WindSpeedMeasurmentUnit);
      
      UserPreferencesManager preferences = UserPreferencesManager.getInstance();
        tempList.setValue(preferences.getTemperatureUnit());
        windList.setValue(preferences.getWindSpeedUnit());

    }

}


