package com.github.mgt6.weatherstation.dto;


import java.time.LocalDateTime;

public class SensorReadingDto {

    private String key;
    private String value;
    private String sensorId;
    private String id;
    private LocalDateTime readingDate;


    public SensorReadingDto(String key, String value, String sensorId, String id, LocalDateTime readingDate) {
        this.key = key;
        this.value = value;
        this.sensorId = sensorId;
        this.id = id;
        this.readingDate = readingDate;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getReadingDate() {
        return readingDate;
    }
}
