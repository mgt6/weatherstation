package com.github.mgt6.weatherstation.dto;

/**
 * Basic Sensor Model to return to the view.
 */
public class SensorDto {

    /**
     * The Id of the sensor
     */
    private String id;

    /**
     * The name of the Sensor.
     */
    private String name;

    /**
     * The description of the Sensor
     */
    private String description;

    public SensorDto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
