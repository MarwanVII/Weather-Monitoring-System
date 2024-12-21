package com.marwan.weather.monitoring.system;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherDataFetcher {
    // Method to fetch weather data from an API (OpenWeatherMap)
    private static final String API_KEY = "408a52444af6f2efe82d36c5e5da39c4"; 
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public void fetchWeatherData(String city) {
        try {
            // Build URL for API request
            String url = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, city, API_KEY);
            
            // Send GET request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                // Parse the response JSON
                JSONObject weatherData = new JSONObject(response.body());
                
                // Extract weather data (temperature, wind speed, humidity)
                double temp = weatherData.getJSONObject("main").getDouble("temp");
                double windSpeed = weatherData.getJSONObject("wind").getDouble("speed");
                int humidity = weatherData.getJSONObject("main").getInt("humidity");

                // Use the factory to create objects
                WeatherDataType temperature = WeatherDataFactory.createWeatherData("temperature", temp);
                WeatherDataType wind = WeatherDataFactory.createWeatherData("windspeed", windSpeed);
                WeatherDataType humid = WeatherDataFactory.createWeatherData("humidity", humidity);
            } else {
                System.out.println("Failed to fetch weather data: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}
