package com.github.mgt6.weatherstation.repository;

import com.evrythng.thng.resource.model.store.Thng;

import java.util.List;
import java.util.Optional;

public interface SensorRepository {

    /**
     * Method to get all of the registered sensors for this application.
     *
     * @return An optional list of things that will contain either a populated {@link java.util.List List} of
     * {@link com.evrythng.thng.resource.model.store.Thng Thngs} or it will be empty.
     */
    Optional<List<Thng>> getSensors();
}
