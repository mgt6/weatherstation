package com.github.mgt6.weatherstation.repository.impl.mock.data;


import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.domain.ThngBuilder;

import java.util.HashMap;
import java.util.Map;

public class MockRainSensor {

    public static Thng thng;

    public static Map<String, Property> properties = new HashMap<String, Property>();

    static {

        thng = new ThngBuilder().withId("UdqcgxtgsB5RAnybdxC6BHsc")
                .withName("Rain Sensor")
                .withDescription("A sensor for detecting the current rate of rain fall.")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("rainfall", "0.0")
                .build();

        properties.put("type", new PropertyBuilder().withId("1").withKey("type").withValue("rainfall").build());
        properties.put("rainfall", new PropertyBuilder().withId("1").withKey("rainfall").withValue("0.0").build());
    }
}
