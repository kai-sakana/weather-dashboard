package com.example.demo.dto;

import com.example.demo.model.WeatherType;

public class HourlyForecastDto {
    private String time;        // "14:00" など
    private double temperature;
    private WeatherType weatherType;

    public HourlyForecastDto(String time, double temperature, WeatherType weatherType) {
        this.time = time;
        this.temperature = temperature;
        this.weatherType = weatherType;
    }

    // Getter (赤線を消すために必須です)
    public String getTime() { return time; }
    public double getTemperature() { return temperature; }
    public WeatherType getWeatherType() { return weatherType; }
}
