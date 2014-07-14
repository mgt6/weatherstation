package com.github.mgt6.weatherstation.mock;


import com.evrythng.thng.resource.model.store.Property;

public class MockPropertyBuilder {

    public static Property getMockProperty() {
        Property property = new Property();
        property.setId("1");
        property.setKey("type");
        property.setValue("mock");
        return property;
    }
}
