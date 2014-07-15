package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.dto.SensorReadingDto;
import com.github.mgt6.weatherstation.exception.ResourceNotFoundException;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A sensor service which makes calls to the Repository and return the results as models.
 */
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    /**
     * The field used to hold the name of the reading type.
     */
    private static final String READING_TYPE_FIELD = "type";

    /**
     * Gets all of the sensors for the application.
     *
     * If there are no sensors then an empty list is returned.
     *
     * @return A list of {@link SensorDto SensorDtos}.
     */
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

    /**
     * Gets a single sensor by its Id.
     *
     * If no sensor with that Id is found then a {@link ResourceNotFoundException} is thrown.
     *
     * @param id the id of the sensor.
     * @return The sensor with that Id.
     */
    public SensorDto getSensor(String id) {
        Optional<Thng> thng = sensorRepository.getSensor(id);
        if(thng.isPresent()) {
            Thng result = thng.get();
            return new SensorDto(result.getId(), result.getName(), result.getDescription());
        }
        throw new ResourceNotFoundException();
    }

    /**
     * Gets the latest sensor reading for a given sensor.
     *
     * If no sensor with that Id is found then a {@link ResourceNotFoundException} is thrown.
     *
     * @param sensorId the Id of the sensor to get the reading for.
     * @return the reading of the sensor.
     */
    public SensorReadingDto getLatestSensorReading(String sensorId) {
        Optional<Property> typeField = sensorRepository.getLatestPropertyReading(sensorId, READING_TYPE_FIELD);
        if(typeField.isPresent()) {
            Property typeFieldResult = typeField.get();
            String typeFieldValue = typeFieldResult.getValue();
            Optional<Property> readingField = sensorRepository.getLatestPropertyReading(sensorId, typeFieldValue);

            if(readingField.isPresent()) {
                Property reading = readingField.get();
                LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(reading.getTimestamp()), ZoneId.systemDefault());
                return new SensorReadingDto(reading.getKey(), reading.getValue(), sensorId, reading.getId(), time);
            }
        }
        throw new ResourceNotFoundException();
    }

    /**
     * Gets all of the readings for a given sensor.
     *
     * If no sensor with that Id is found then a {@link ResourceNotFoundException} is thrown.
     *
     * If there are no readings for the sensor but it does exist then an empty list is returned.
     *
     * @param sensorId The id of the sensor to get the readings for.
     * @return A list of Readings for that sensor.
     */
    public List<SensorReadingDto> getSensorReadings(String sensorId) {
        Optional<Property> typeField = sensorRepository.getLatestPropertyReading(sensorId, READING_TYPE_FIELD);
        List<SensorReadingDto> readings = new ArrayList<>();
        if(typeField.isPresent()) {
            Property typeProperty = typeField.get();
            Optional<List<Property>> properties = sensorRepository.getAllProperties(sensorId, typeProperty.getValue());
            if(properties.isPresent() && !properties.get().isEmpty()) {
                for (Property reading : properties.get()) {
                    LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(reading.getTimestamp()), ZoneId.systemDefault());
                    readings.add(new SensorReadingDto(reading.getKey(), reading.getValue(), sensorId, reading.getId(), time));
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
