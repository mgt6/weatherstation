package com.github.mgt6.weatherstation.repository.impl.evrythng;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.exception.EvrythngException;
import com.evrythng.java.wrapper.service.ThngService;
import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class EvrythngSensorRepository implements SensorRepository {

    Logger LOGGER = LoggerFactory.getLogger(EvrythngSensorRepository.class);

    private ThngService thngService;

    public EvrythngSensorRepository(ApiManager api) {
        thngService = api.thngService();
    }

    public Optional<List<Thng>> getSensors(){
        Optional<List<Thng>> results = Optional.empty();
        try {
            List<Thng> thngs = thngService.thngsReader().list().getResult();
            if(thngs != null && !thngs.isEmpty()) {
                results = Optional.of(thngs);
            }
        } catch (EvrythngException e) {
            LOGGER.error("Error getting response from Evrythng: " + e.getMessage());
        }
        return results;
    }

    public Optional<Property> getProperty(String id) {
        Optional<Property> results = Optional.empty();
        try {
            List<Property> type = thngService.propertyReader(id, "type").list().getResult();
            if(type != null && !type.isEmpty()) {
                String sensorType = type.iterator().next().getValue();
                List<Property> properties = thngService.propertyReader(id, sensorType).list().getResult();
                if(properties != null && !properties.isEmpty()) {
                    results = Optional.of(properties.iterator().next());
                }
            }
        } catch (EvrythngException e) {
            LOGGER.error("Error getting response from Evrythng: " + e.getMessage());
        }
        return results;
    }
}
