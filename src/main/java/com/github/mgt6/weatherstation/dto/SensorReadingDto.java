package com.github.mgt6.weatherstation.dto;


public class SensorReadingDto {
    private String key;
    private String value;
    private String sensorId;
    private String id;


    public SensorReadingDto(String key, String value, String sensorId, String id) {
        this.key = key;
        this.value = value;
        this.sensorId = sensorId;
        this.id = id;
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
}
