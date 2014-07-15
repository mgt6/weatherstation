package com.github.mgt6.weatherstation.dto;

import java.time.LocalDateTime;

/**
 * Basic class representing a sensor reading model.
 */
public class SensorReadingDto {

    /**
     * The id of this reading.
     */
    private String id;

    /**
     * The name of the field
     */
    private String key;

    /**
     * The value held in the field.
     */
    private String value;

    /**
     * The id of the sensor that this reading comes from.
     */
    private String sensorId;

    /**
     * The date and time this reading was taken
     */
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
