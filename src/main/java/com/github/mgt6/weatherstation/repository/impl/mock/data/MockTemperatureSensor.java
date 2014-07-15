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

public class MockTemperatureSensor {

    public static Thng thng;

    public static Map<String, List<Property>> properties = new HashMap<>();

    static {

        thng = new ThngBuilder().withId("UdqyXcUqPBpRf5qM7KVHQpkm")
                .withName("Temperature Sensor")
                .withDescription("A Sensor to determine the current temperature")
                .withProduct("UA6cDx3pPVKaAHcbUbC6Bngn")
                .withProperty("temperature", "22.1")
                .build();

        properties.put("type", Arrays.asList(new PropertyBuilder().withId("1").withKey("type").withValue("temperature").withTimeStamp(LocalDateTime.now().minusDays(5)).build()));
        properties.put("temperature", Arrays.asList(new PropertyBuilder().withId("2").withKey("temperature").withValue("22.1").withTimeStamp(LocalDateTime.now()).build(),
                new PropertyBuilder().withId("3").withKey("temperature").withValue("22.1").withTimeStamp(LocalDateTime.now().plusMinutes(5)).build(),
                new PropertyBuilder().withId("4").withKey("temperature").withValue("22.2").withTimeStamp(LocalDateTime.now().plusMinutes(10)).build(),
                new PropertyBuilder().withId("5").withKey("temperature").withValue("22.3").withTimeStamp(LocalDateTime.now().plusMinutes(15)).build(),
                new PropertyBuilder().withId("6").withKey("temperature").withValue("22.4").withTimeStamp(LocalDateTime.now().plusMinutes(20)).build(),
                new PropertyBuilder().withId("7").withKey("temperature").withValue("22.5").withTimeStamp(LocalDateTime.now().plusMinutes(25)).build(),
                new PropertyBuilder().withId("8").withKey("temperature").withValue("22.5").withTimeStamp(LocalDateTime.now().plusMinutes(30)).build(),
                new PropertyBuilder().withId("9").withKey("temperature").withValue("22.7").withTimeStamp(LocalDateTime.now().plusMinutes(35)).build(),
                new PropertyBuilder().withId("10").withKey("temperature").withValue("22.8").withTimeStamp(LocalDateTime.now().plusMinutes(40)).build(),
                new PropertyBuilder().withId("11").withKey("temperature").withValue("23.1").withTimeStamp(LocalDateTime.now().plusMinutes(45)).build(),
                new PropertyBuilder().withId("12").withKey("temperature").withValue("23.5").withTimeStamp(LocalDateTime.now().plusMinutes(50)).build(),
                new PropertyBuilder().withId("13").withKey("temperature").withValue("23.8").withTimeStamp(LocalDateTime.now().plusMinutes(55)).build(),
                new PropertyBuilder().withId("14").withKey("temperature").withValue("24.1").withTimeStamp(LocalDateTime.now().plusMinutes(60)).build(),
                new PropertyBuilder().withId("15").withKey("temperature").withValue("24.2").withTimeStamp(LocalDateTime.now().plusMinutes(65)).build(),
                new PropertyBuilder().withId("16").withKey("temperature").withValue("24.3").withTimeStamp(LocalDateTime.now().plusMinutes(70)).build(),
                new PropertyBuilder().withId("17").withKey("temperature").withValue("24.4").withTimeStamp(LocalDateTime.now().plusMinutes(75)).build(),
                new PropertyBuilder().withId("18").withKey("temperature").withValue("24.7").withTimeStamp(LocalDateTime.now().plusMinutes(80)).build(),
                new PropertyBuilder().withId("19").withKey("temperature").withValue("24.9").withTimeStamp(LocalDateTime.now().plusMinutes(85)).build(),
                new PropertyBuilder().withId("20").withKey("temperature").withValue("25.1").withTimeStamp(LocalDateTime.now().plusMinutes(90)).build(),
                new PropertyBuilder().withId("21").withKey("temperature").withValue("25.0").withTimeStamp(LocalDateTime.now().plusMinutes(95)).build(),
                new PropertyBuilder().withId("22").withKey("temperature").withValue("25.1").withTimeStamp(LocalDateTime.now().plusMinutes(100)).build(),
                new PropertyBuilder().withId("23").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(105)).build(),
                new PropertyBuilder().withId("24").withKey("temperature").withValue("25.1").withTimeStamp(LocalDateTime.now().plusMinutes(110)).build(),
                new PropertyBuilder().withId("25").withKey("temperature").withValue("25.1").withTimeStamp(LocalDateTime.now().plusMinutes(115)).build(),
                new PropertyBuilder().withId("26").withKey("temperature").withValue("25.3").withTimeStamp(LocalDateTime.now().plusMinutes(120)).build(),
                new PropertyBuilder().withId("27").withKey("temperature").withValue("25.1").withTimeStamp(LocalDateTime.now().plusMinutes(125)).build(),
                new PropertyBuilder().withId("28").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(130)).build(),
                new PropertyBuilder().withId("29").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(135)).build(),
                new PropertyBuilder().withId("30").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(140)).build(),
                new PropertyBuilder().withId("31").withKey("temperature").withValue("25.3").withTimeStamp(LocalDateTime.now().plusMinutes(145)).build(),
                new PropertyBuilder().withId("32").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(150)).build(),
                new PropertyBuilder().withId("33").withKey("temperature").withValue("25.2").withTimeStamp(LocalDateTime.now().plusMinutes(155)).build(),
                new PropertyBuilder().withId("34").withKey("temperature").withValue("25.3").withTimeStamp(LocalDateTime.now().plusMinutes(160)).build()));
    }

}
