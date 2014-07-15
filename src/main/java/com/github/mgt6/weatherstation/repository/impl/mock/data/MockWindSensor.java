package com.github.mgt6.weatherstation.repository.impl.mock.data;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.domain.ThngBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockWindSensor {

    public static Thng thng;

    public static Map<String, List<Property>> properties = new HashMap<>();

    static {

        thng = new ThngBuilder().withId("Ud6yDyFTsVpaGNFEDaCN5nPg")
                .withName("Wind Sensor")
                .withDescription("A sensor to determine the current wind speed and direction")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("windspeed", "0.9")
                .build();

        properties.put("type", Arrays.asList(new PropertyBuilder().withId("1").withKey("type").withValue("windspeed").build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("2").withKey("windspeed").withValue("0.9").build()));
    }
}
