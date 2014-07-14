package com.github.mgt6.weatherstation.repository.impl.mock;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.domain.ThngBuilder;
import com.github.mgt6.weatherstation.repository.SensorRepository;

import java.util.*;

public class MockSensorRepository implements SensorRepository {

    private static Map<String, Map<String, String>> properties = new HashMap<String, Map<String, String>>();
    private static Map<String, String> rainSensorProperties = new HashMap<String, String>();
    private static Map<String, String> windSensorProperties = new HashMap<String, String>();
    private static Map<String, String> temperatureSensorProperties = new HashMap<String, String>();

    static {

        rainSensorProperties.put("type", "rainfall");
        rainSensorProperties.put("rainfall", "0.0");

        windSensorProperties.put("type", "windspeed");
        windSensorProperties.put("windspeed", "0.9");

        temperatureSensorProperties.put("type", "temperature");
        temperatureSensorProperties.put("temperature", "22.1");

        properties.put("UdqcgxtgsB5RAnybdxC6BHsc", rainSensorProperties);
        properties.put("Ud6yDyFTsVpaGNFEDaCN5nPg", windSensorProperties);
        properties.put("UdqyXcUqPBpRf5qM7KVHQpkm", temperatureSensorProperties);
    }

    @Override
    public Optional<List<Thng>> getSensors() {
        List<Thng> thngs = new ArrayList<Thng>();
        thngs.add(new ThngBuilder().withId("UdqcgxtgsB5RAnybdxC6BHsc")
                .withName("Rain Sensor")
                .withDescription("A sensor for detecting the current rate of rain fall.")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("rainfall", "0.0")
                .build());
        thngs.add(new ThngBuilder().withId("Ud6yDyFTsVpaGNFEDaCN5nPg")
                .withName("Wind Sensor")
                .withDescription("A sensor to determine the current wind speed and direction")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("windspeed", "0.9")
                .build());
        thngs.add(new ThngBuilder().withId("UdqyXcUqPBpRf5qM7KVHQpkm")
                .withName("Temperature Sensor")
                .withDescription("A Sensor to determine the current temperature")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("temperature", "22.1")
                .build());
        return Optional.of(thngs);
    }

    @Override
    public Optional<Property> getLatestPropertyReading(String thngId, String propertyName) {
        Optional<Property> property = Optional.empty();
        if (properties.containsKey(thngId) && properties.get(thngId).containsKey(propertyName)) {
            return Optional.of(new PropertyBuilder().withId("2").withKey(propertyName).withValue(properties.get(thngId).get(propertyName)).build());
        }
        return property;
    }

}
