package com.marwan.weather.monitoring.system;

/**
 *
 * @author mohmm
 */
public class UserPreferencesManager {
    private static UserPreferencesManager instance;
    private String temperatureUnit = "°C";
    private String windSpeedUnit = "Km/h";
    
    private UserPreferencesManager() {}
    
    public static UserPreferencesManager getInstance() {
        if (instance == null) {
            instance = new UserPreferencesManager();
        }
        return instance;
    }
    
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String unit) {
        this.temperatureUnit = unit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public void setWindSpeedUnit(String unit) {
        this.windSpeedUnit = unit;
    }

}
