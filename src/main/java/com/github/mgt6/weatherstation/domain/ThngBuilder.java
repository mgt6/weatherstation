package com.github.mgt6.weatherstation.domain;

import com.evrythng.thng.resource.model.store.Thng;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to create Thng objects.
 */
public class ThngBuilder {

    /**
     * The id of the object, this would normally be set by the database but we need to mock it here.
     */
    private String id;

    /**
     * The name of the Thng, used as a human readable identifier.
     */
    private String name;

    /**
     * A description of the Thng, used to give more details of what this object does.
     */
    private String description;

    /**
     * The product that this Thng belongs to.
     */
    private String product;

    /**
     * A list of properties associated with this Thng.
     */
    private Map<String, String> properties = new HashMap<>();

    /**
     * Sets the id of this Thng.
     *
     * @param id The id to set.
     * @return This builder for chaining.
     */
    public ThngBuilder withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the name of this Thng.
     *
     * @param name The name of the Thng.
     * @return This builder for chaining.
     */
    public ThngBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the description of this Thng.
     *
     * @param description The description of the Thng.
     * @return This builder for chaining.
     */
    public ThngBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the product of this Thng.
     *
     * @param product The product that the Thng belongs to.
     * @return This builder for chaining.
     */
    public ThngBuilder withProduct(String product) {
        this.product = product;
        return this;
    }

    /**
     * Adds a map of properties to this Thng, any existing properties will be kept with the new ones added along side.
     *
     * @param properties The properties to add.
     * @return This builder for chaining.
     */
    public ThngBuilder withProperties(Map<String, String> properties) {
        this.properties.putAll(properties);
        return this;
    }

    /**
     * Adds a single property Key value pair to the Thng any existing properties will be kept with the new one added along side.
     *
     * @param key The key used to identify this property.
     * @param value The value of the property.
     * @return This Builder for Chaining.
     */
    public ThngBuilder withProperty(String key, String value) {
        this.properties.put(key, value);
        return this;
    }

    /**
     * Creates a new Thng object using the properties set in the builder, normally appears at the end of a builder chain, for example:
     * <code>
     *     Thng thng = new ThngBuilder.withId("1").withName("My cool Thng").withProduct("My cool product").Build();
     * </code>
     * @return
     */
    public Thng build() {
        Thng thng = new Thng();
        thng.setId(id);
        thng.setName(name);
        thng.setDescription(description);
        thng.setProduct(product);
        thng.setProperties(properties);
        return thng;
    }
}
