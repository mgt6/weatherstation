package com.github.mgt6.weatherstation.repository.impl.mock.data;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.PropertyBuilder;
import com.github.mgt6.weatherstation.domain.ThngBuilder;

import java.time.LocalDateTime;
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

        properties.put("type", Arrays.asList(new PropertyBuilder().withId("1").withKey("type").withValue("windspeed").withTimeStamp(LocalDateTime.now().minusDays(5)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("2").withKey("windspeed").withValue("0.9").withTimeStamp(LocalDateTime.now()).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("1.3").withTimeStamp(LocalDateTime.now().plusMinutes(1)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("1.4").withTimeStamp(LocalDateTime.now().plusMinutes(2)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("1.2").withTimeStamp(LocalDateTime.now().plusMinutes(3)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.8").withTimeStamp(LocalDateTime.now().plusMinutes(4)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.8").withTimeStamp(LocalDateTime.now().plusMinutes(5)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.6").withTimeStamp(LocalDateTime.now().plusMinutes(6)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.3").withTimeStamp(LocalDateTime.now().plusMinutes(7)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.3").withTimeStamp(LocalDateTime.now().plusMinutes(8)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.2").withTimeStamp(LocalDateTime.now().plusMinutes(9)).build()));
        properties.put("windspeed", Arrays.asList(new PropertyBuilder().withId("3").withKey("windspeed").withValue("0.1").withTimeStamp(LocalDateTime.now().plusMinutes(10)).build()));
    }
}
