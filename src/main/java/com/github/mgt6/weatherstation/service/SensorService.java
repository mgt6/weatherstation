package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.dto.SensorReadingDto;
import com.github.mgt6.weatherstation.exception.ResourceNotFoundException;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    private static final String READING_TYPE_FIELD = "type";

    public List<SensorDto> getSensors() {
        Optional<List<Thng>> thngs = sensorRepository.getSensors();
        List<SensorDto> sensors = new ArrayList<>();
        if(thngs.isPresent()) {
            for (Thng thng : thngs.get()) {
                sensors.add(new SensorDto(thng.getId(), thng.getName(), thng.getDescription()));
            }
        }
        return sensors;
    }

    public SensorDto getSensor(String id) {
        Optional<Thng> thng = sensorRepository.getSensor(id);
        if(thng.isPresent()) {
            Thng result = thng.get();
            return new SensorDto(result.getId(), result.getName(), result.getDescription());
        }
        throw new ResourceNotFoundException();
    }

    public SensorReadingDto getLatestSensorReading(String sensorId) {
        Optional<Property> typeField = sensorRepository.getLatestPropertyReading(sensorId, READING_TYPE_FIELD);
        if(typeField.isPresent()) {
            Property typeFieldResult = typeField.get();
            String typeFieldValue = typeFieldResult.getValue();
            Optional<Property> readingField = sensorRepository.getLatestPropertyReading(sensorId, typeFieldValue);

            if(readingField.isPresent()) {
                Property reading = readingField.get();
                return new SensorReadingDto(reading.getKey(), reading.getValue(), sensorId, reading.getId());
            }
        }
        throw new ResourceNotFoundException();
    }

    public List<SensorReadingDto> getSensorReadings(String sensorId) {
        Optional<Property> typeField = sensorRepository.getLatestPropertyReading(sensorId, READING_TYPE_FIELD);
        List<SensorReadingDto> readings = new ArrayList<>();
        if(typeField.isPresent()) {
            Property typeProperty = typeField.get();
            Optional<List<Property>> properties = sensorRepository.getAllProperties(sensorId, typeProperty.getValue());
            if(properties.isPresent() && !properties.get().isEmpty()) {
                for (Property property : properties.get()) {
                    readings.add(new SensorReadingDto(property.getKey(), property.getValue(), sensorId, property.getId()));
                }
            }
        }
        return readings;
    }

    @Required
    public void setSensorRepository(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }
}
