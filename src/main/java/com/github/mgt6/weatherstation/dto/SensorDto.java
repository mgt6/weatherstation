package com.github.mgt6.weatherstation.dto;

public class SensorDto {

    public String id;

    public String name;

    public SensorDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SensorDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
