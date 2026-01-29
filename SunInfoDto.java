package com.example.demo.dto;

public class SunInfoDto {
    private String sunrise;
    private String sunset;
    private String dayLength;

    // constructor / getter

    public SunInfoDto(String sunrise, String sunset, String dayLength) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.dayLength = dayLength;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getDayLength() {
        return dayLength;
    }
}
