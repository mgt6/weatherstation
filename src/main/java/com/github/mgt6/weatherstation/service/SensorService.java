package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.dto.SensorReadingDto;
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
        List<SensorDto> sensors = new ArrayList<SensorDto>();
        if(thngs.isPresent()) {
            for (Thng thng : thngs.get()) {
                sensors.add(new SensorDto(thng.getId(), thng.getName(), thng.getDescription()));
            }
        }
        return sensors;
    }

    @Required
    public void setSensorRepository(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
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
        return null;
    }
}
