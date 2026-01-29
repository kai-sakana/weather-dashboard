package com.example.demo.dto;

public class TimeLineDto {
    private String time;
    private String condition;
    private String impact;

    public TimeLineDto(String time, String condition, String impact) {
        this.time = time;
        this.condition = condition;
        this.impact = impact;
    }

    // Getter
    public String getTime() { return time; }
    public String getCondition() { return condition; }
    public String getImpact() { return impact; }
}
