package com.github.mgt6.weatherstation.service;

import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.dto.SensorDto;
import com.github.mgt6.weatherstation.mock.MockThngBuilder;
import com.github.mgt6.weatherstation.repository.SensorRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
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

        assertThat(sensorDto.id, is("1"));
        assertThat(sensorDto.name, is("Mock"));
        assertThat(sensorDto.description, is("Mock Thng"));
    }

    @Test
    public void testGetSensorsEmptyResult() throws Exception {
        when(sensorRepository.getSensors()).thenReturn(Optional.<List<Thng>>empty());
        List<SensorDto> sensors = sensorService.getSensors();
        assertTrue(sensors.isEmpty());
    }

}