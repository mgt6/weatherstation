package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

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
}
