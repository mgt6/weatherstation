package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.dto.SensorReadingDto;
import com.github.mgt6.weatherstation.exception.ResourceNotFoundException;
import com.github.mgt6.weatherstation.mock.MockPropertyBuilder;
import com.github.mgt6.weatherstation.mock.MockThngBuilder;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SensorServiceTest {


    SensorService sensorService = new SensorService();

    SensorRepository sensorRepository = mock(SensorRepository.class);

    @Before
    public void setUp() throws Exception {
        sensorService.setSensorRepository(sensorRepository);
    }

    @Test
    public void testGetSensors() throws Exception {
        when(sensorRepository.getSensors()).thenReturn(Optional.of(MockThngBuilder.getMockThngs()));
        List<SensorDto> sensors = sensorService.getSensors();

        assertThat(sensors.size(), is(1));

        SensorDto sensorDto = sensors.iterator().next();

        assertThat(sensorDto.getId(), is("1"));
        assertThat(sensorDto.getName(), is("Mock"));
        assertThat(sensorDto.getDescription(), is("Mock Thng"));
    }

    @Test
    public void testGetSensorsEmptyResult() throws Exception {
        when(sensorRepository.getSensors()).thenReturn(Optional.<List<Thng>>empty());
        List<SensorDto> sensors = sensorService.getSensors();
        assertTrue(sensors.isEmpty());
    }

    @Test
    public void testGetLatestReading() throws Exception {
        when(sensorRepository.getLatestPropertyReading("1", "type")).thenReturn(Optional.of(MockPropertyBuilder.getMockProperty()));
        when(sensorRepository.getLatestPropertyReading("1", "mock")).thenReturn(Optional.of(MockPropertyBuilder.getMockPropertyReading()));
        SensorReadingDto sensorReading = sensorService.getLatestSensorReading("1");

        assertNotNull(sensorReading);
        assertThat(sensorReading.getKey(), is("mock"));
        assertThat(sensorReading.getValue(), is("0.00"));
        assertThat(sensorReading.getSensorId(), is("1"));
        assertThat(sensorReading.getId(), is("2"));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetLatestResultsNotFound() {
        when(sensorRepository.getLatestPropertyReading("1", "type")).thenReturn(Optional.of(MockPropertyBuilder.getMockProperty()));
        when(sensorRepository.getLatestPropertyReading("1", "mock")).thenReturn(Optional.<Property>empty());
        sensorService.getLatestSensorReading("1");
    }

    @Test
    public void testGetSensor() {
        when(sensorRepository.getSensor("1")).thenReturn(Optional.of(MockThngBuilder.getThng()));
        SensorDto sensorDto = sensorService.getSensor("1");

        assertThat(sensorDto.getId(), is("1"));
        assertThat(sensorDto.getName(), is("Mock"));
        assertThat(sensorDto.getDescription(), is("Mock Thng"));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetSensorNull() {
        when(sensorRepository.getSensor("1")).thenReturn(Optional.<Thng>empty());
        sensorService.getSensor("1");
    }

}