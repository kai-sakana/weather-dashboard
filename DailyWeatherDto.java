package com.example.demo.dto;
import java.time.LocalDate;

public record DailyWeatherDto(LocalDate date, String weather, int maxTemp, int minTemp) {}
