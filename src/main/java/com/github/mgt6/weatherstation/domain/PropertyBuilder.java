package com.github.mgt6.weatherstation.domain;

import com.evrythng.thng.resource.model.store.Property;

public class PropertyBuilder {

    /**
     * The id of the property.
     */
    private String id;

    /**
     * The key used to identify this property.
     */
    private String key;

    /**
     * The value held within this property.
     */
    private String value;

    /**
     * Sets the id of the property to create.
     *
     * @param id The id to set.
     * @return This builder for chaining
     */
    public PropertyBuilder withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the key of this property.
     *
     * @param key The key to set.
     * @return This builder for chaining.
     */
    public PropertyBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * Sets the value of this property.
     *
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public PropertyBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public Property build() {
        Property property = new Property();
        property.setId(id);
        property.setKey(key);
        property.setValue(value);
        return property;
    }
}
