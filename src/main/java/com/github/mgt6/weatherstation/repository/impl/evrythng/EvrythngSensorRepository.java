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

    public Optional<List<Thng>> getSensors() {
        Optional<List<Thng>> results = Optional.empty();
        try {
            List<Thng> thngs = thngService.thngsReader().list().getResult();
            if (thngs != null && !thngs.isEmpty()) {
                results = Optional.of(thngs);
            }
        } catch (EvrythngException e) {
            LOGGER.error("Error getting response from Evrythng: " + e.getMessage());
        }
        return results;
    }

    @Override
    public Optional<Property> getLatestPropertyReading(String thngId, String propertyName) {
        Optional<Property> property = Optional.empty();
        try {
            List<Property> properties = thngService.propertyReader(thngId, propertyName).execute();
            if (properties != null && !properties.isEmpty()) {
                property = Optional.of(properties.get(0));
            }
        } catch (EvrythngException e) {
            LOGGER.error("Error getting response from Evrythng: " + e.getMessage());
        }
        return property;
    }

    @Override
    public Optional<List<Property>> getAllProperties(String thngId, String propertyName) {
        Optional<List<Property>> properties = Optional.empty();
        try {
            List<Property> results = thngService.propertyReader(thngId, propertyName).execute();
            if(results != null && !results.isEmpty()) {
                properties = Optional.of(results);
            }
        } catch (EvrythngException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public Optional<Thng> getSensor(String sensorId) {
        Optional<Thng> thng = Optional.empty();

        try {
            Thng result = thngService.thngReader(sensorId).execute();
            if(result != null) {
                thng = Optional.of(result);
            }
        } catch (EvrythngException e) {
            LOGGER.error("Error getting response from Evrythng: " + e.getMessage());
        }
        return thng;

    }
}
