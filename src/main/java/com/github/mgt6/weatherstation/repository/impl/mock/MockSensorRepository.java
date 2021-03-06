package com.github.mgt6.weatherstation.repository.impl.mock;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import com.github.mgt6.weatherstation.repository.impl.mock.data.MockRainSensor;
import com.github.mgt6.weatherstation.repository.impl.mock.data.MockTemperatureSensor;
import com.github.mgt6.weatherstation.repository.impl.mock.data.MockWindSensor;

import java.util.*;

/**
 * An implementation of {@link SensorRepository} which uses mock data from:
 * <ul>
 *     <li>{@link MockRainSensor}</li>
 *     <li>{@link MockWindSensor}</li>
 *     <li>{@link MockTemperatureSensor}</li>
 * </ul>
 *
 */
public class MockSensorRepository implements SensorRepository {

    private static Map<String, Map<String, List<Property>>> properties = new HashMap<>();
    private static Map<String, Thng> thngsMap = new HashMap<>();

    static {

        thngsMap.put("UdqcgxtgsB5RAnybdxC6BHsc", MockRainSensor.thng);
        thngsMap.put("Ud6yDyFTsVpaGNFEDaCN5nPg", MockWindSensor.thng);
        thngsMap.put("UdqyXcUqPBpRf5qM7KVHQpkm", MockTemperatureSensor.thng);

        properties.put("UdqcgxtgsB5RAnybdxC6BHsc", MockRainSensor.properties);
        properties.put("Ud6yDyFTsVpaGNFEDaCN5nPg", MockWindSensor.properties);
        properties.put("UdqyXcUqPBpRf5qM7KVHQpkm", MockTemperatureSensor.properties);

    }

    @Override
    public Optional<List<Thng>> getSensors() {
        List<Thng> thngs = new ArrayList<>();
        for (String id : thngsMap.keySet()) {
            thngs.add(thngsMap.get(id));
        }
        return Optional.of(thngs);
    }

    @Override
    public Optional<Property> getLatestPropertyReading(String thngId, String propertyName) {
        if (properties.containsKey(thngId)) {
            Map<String, List<Property>> sensorProperties = properties.get(thngId);
            if (sensorProperties.containsKey(propertyName)) {
                Property property = sensorProperties.get(propertyName).iterator().next();
                return Optional.of(new PropertyBuilder().withId(property.getId()).withKey(property.getKey()).withValue(property.getValue()).withTimeStamp(property.getTimestamp()).build());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Property>> getAllProperties(String thngId, String propertyName) {
        if (properties.containsKey(thngId) && properties.get(thngId).containsKey(propertyName)) {
            List<Property> sensorProperties = properties.get(thngId).get(propertyName);
            return Optional.of(sensorProperties);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Thng> getSensor(String sensorId) {
        if (thngsMap.containsKey(sensorId)) {
            return Optional.of(thngsMap.get(sensorId));
        }
        return Optional.empty();
    }

}
