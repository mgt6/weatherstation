package com.github.mgt6.weatherstation.repository;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;

import java.util.List;
import java.util.Optional;

/**
 * An interface for any repository that will return sensor data.
 */
public interface SensorRepository {

    /**
     * Method to get all of the registered sensors for this application.
     *
     * @return An optional list of things that will contain either a populated {@link List} of {@link Thng Thngs}
     * or it will be empty.
     */
    Optional<List<Thng>> getSensors();

    /**
     * Method to get the latest reading of an individual property of a thng.
     *
     * @param thngId The id of the {@link Thng} that contains the property.
     * @param propertyName The name of {@link Property} to get the reading from.
     * @return An optional value which contain a {@link Property} for that {@link Thng} or it will be empty.
     */
    Optional<Property> getLatestPropertyReading(String thngId, String propertyName);

    /**
     * Method to get all of the properties with a given name. This will return all of the properties with that name as they have
     * changed over time.
     *
     * @param thngId The id of the {@link com.evrythng.thng.resource.model.store.Thng} with the properties to get.
     * @param propertyName The name of the {@link com.evrythng.thng.resource.model.store.Property} to get from the {@link com.evrythng.thng.resource.model.store.Thng}
     * @return An Optional value that will contain either a populated {@link List} of {@link Property properties} or it will be empty
     */
    Optional<List<Property>> getAllProperties(String thngId, String propertyName);

    /**
     * Method to get a single sensor identified by its Id.
     *
     * @param sensorId The id of the sensor to get.
     * @return An Optional containing the {@link Thng} if it is found or it will be empty
     */
    Optional<Thng> getSensor(String sensorId);
}
