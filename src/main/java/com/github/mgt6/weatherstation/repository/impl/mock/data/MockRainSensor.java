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

public class MockRainSensor {

    public static Thng thng;

    public static Map<String, List<Property>> properties = new HashMap<>();

    static {

        thng = new ThngBuilder().withId("UdqcgxtgsB5RAnybdxC6BHsc")
                .withName("Rain Sensor")
                .withDescription("A sensor for detecting the current rate of rain fall.")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("rainfall", "0.0")
                .build();

        properties.put("type", Arrays.asList(new PropertyBuilder().withId("1").withKey("type").withValue("rainfall").withTimeStamp(LocalDateTime.now().minusDays(5)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("2").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now()).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("3").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(1)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("4").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(2)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("5").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(3)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("6").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(4)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("7").withKey("rainfall").withValue("0.1").withTimeStamp(LocalDateTime.now().plusHours(5)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("8").withKey("rainfall").withValue("0.3").withTimeStamp(LocalDateTime.now().plusHours(6)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("9").withKey("rainfall").withValue("0.5").withTimeStamp(LocalDateTime.now().plusHours(7)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("10").withKey("rainfall").withValue("0.1").withTimeStamp(LocalDateTime.now().plusHours(8)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("11").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(9)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("12").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(10)).build()));
        properties.put("rainfall", Arrays.asList(new PropertyBuilder().withId("13").withKey("rainfall").withValue("0.0").withTimeStamp(LocalDateTime.now().plusHours(11)).build()));
    }
}
