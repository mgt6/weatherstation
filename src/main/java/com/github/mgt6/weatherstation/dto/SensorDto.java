package com.github.mgt6.weatherstation.dto;

public class SensorDto {

    public String id;

    public String name;

    public String description;

    public SensorDto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SensorDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
