package com.example.demo.dto;

import com.example.demo.model.WeatherType;
import java.time.DayOfWeek;

public class SimpleDailyForecastDto {

    private DayOfWeek dayOfWeek;
    private WeatherType weatherType;

    public SimpleDailyForecastDto(DayOfWeek dayOfWeek, WeatherType weatherType) {
        this.dayOfWeek = dayOfWeek;
        this.weatherType = weatherType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }
}
