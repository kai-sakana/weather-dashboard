package com.example.demo.dto;

import com.example.demo.model.WeatherType; // WeatherTypeを使っているのでimportが必要

public class HourlyWeatherDto {
    private String time; 
    private int temperature;
    private WeatherType weatherType;
    private int pop;

    public HourlyWeatherDto(String time, int temperature, WeatherType weatherType, int pop) {
        this.time = time;
        this.temperature = temperature;
        this.weatherType = weatherType;
        this.pop = pop;
    }

    // これら（Getter）があることで、HTMLから値を読み取れるようになります
    public String getTime() { return time; }
    public int getTemperature() { return temperature; }
    public WeatherType getWeatherType() { return weatherType; }
    public int getPop() {return pop; }
}
