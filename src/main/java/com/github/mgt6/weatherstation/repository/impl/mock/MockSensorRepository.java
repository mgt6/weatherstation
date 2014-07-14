package com.github.mgt6.weatherstation.repository.impl.mock;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.ThngBuilder;
import com.github.mgt6.weatherstation.repository.SensorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockSensorRepository implements SensorRepository {

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
        return null;
    }

}
