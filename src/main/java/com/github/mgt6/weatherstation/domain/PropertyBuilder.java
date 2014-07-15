package com.github.mgt6.weatherstation.domain;

import com.evrythng.thng.resource.model.store.Property;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Builder class to create {@link Property} objects.
 */
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
     * The time and date that the property was set.
     */
    private long timeStamp;

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

    /**
     * Sets the time that the property was set, the time is converted into a long value representing milliseconds since the Epoch.
     *
     * @param time The time to set.
     * @return This builder for chaining.
     */
    public PropertyBuilder withTimeStamp(LocalDateTime time) {
        ZonedDateTime zdt = time.atZone(ZoneId.systemDefault());
        timeStamp = zdt.toInstant().toEpochMilli();
        return this;
    }

    /**
     * Sets the timestamp as a raw long value.
     *
     * @param time The time to set.
     * @return This builder for chaining.
     */
    public PropertyBuilder withTimeStamp(long time) {
        this.timeStamp = time;
        return this;
    }

    /**
     * Creates a new {@link Property} object with the values set in this builder.
     *
     * @return a new Property object.
     */
    public Property build() {
        Property property = new Property();
        property.setId(id);
        property.setKey(key);
        property.setValue(value);
        property.setTimestamp(timeStamp);
        property.setCreatedAt(timeStamp);
        return property;
    }
}
