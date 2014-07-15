package com.github.mgt6.weatherstation.mock;

import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.domain.ThngBuilder;

import java.util.ArrayList;
import java.util.List;

public class MockThngBuilder {

    public static Thng getThng() {
        return new ThngBuilder().withId("1").withDescription("Mock Thng").withName("Mock").withProduct("mockProduct").withProperty("type", "mock").build();
    }

    public static List<Thng> getMockThngs(){
        List<Thng> thngs = new ArrayList<>();
        thngs.add(MockThngBuilder.getThng());
        return thngs;
    }
}
