package com.github.mgt6.weatherstation.repository.impl.mock.data;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.domain.ThngBuilder;

import java.util.HashMap;
import java.util.Map;

public class MockTemperatureSensor {

    public static Thng thng;

    public static Map<String, Property> properties = new HashMap<String, Property>();

    static {

        thng = new ThngBuilder().withId("UdqyXcUqPBpRf5qM7KVHQpkm")
                .withName("Temperature Sensor")
                .withDescription("A Sensor to determine the current temperature")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("temperature", "22.1")
                .build();

        properties.put("type", new PropertyBuilder().withId("1").withKey("type").withValue("temperature").build());
        properties.put("temperature", new PropertyBuilder().withId("2").withKey("temperature").withValue("22.1").build());
    }

}
