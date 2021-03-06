package com.github.mgt6.weatherstation.repository;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.core.EvrythngApiBuilder.Builder;
import com.evrythng.java.wrapper.service.ThngService;
import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.mock.MockPropertyBuilder;
import com.github.mgt6.weatherstation.mock.MockThngBuilder;
import com.github.mgt6.weatherstation.repository.impl.evrythng.EvrythngSensorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EvrythngSensorRepositoryTest {

    private EvrythngSensorRepository sensorRepository;

    private ApiManager api = mock(ApiManager.class);

    private ThngService thngService = mock(ThngService.class);

    private Builder thngBuilder = mock(Builder.class);

    private Builder propertyBuilder = mock(Builder.class);

    private Builder.Result thngResult = mock(Builder.Result.class);

    @Before
    public void setUp() throws Exception {
        when(api.thngService()).thenReturn(thngService);
        sensorRepository = new EvrythngSensorRepository(api);
    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset(thngBuilder, propertyBuilder, thngResult);
    }

    @Test
    public void testGetSensors() throws Exception {
        when(thngService.thngsReader()).thenReturn(thngBuilder);
        when(thngBuilder.list()).thenReturn(thngResult);
        when(thngResult.getResult()).thenReturn(MockThngBuilder.getMockThngs());
        Optional<List<Thng>> thngs = sensorRepository.getSensors();

        assertTrue(thngs.isPresent());
        List<Thng> results = thngs.get();
        assertThat(results.size(), is(1));
        assertThat(results.iterator().next().getId(), is("1"));
    }

    @Test
    public void testGetSensorsReturnsEmptyList() throws Exception {
        when(thngService.thngsReader()).thenReturn(thngBuilder);
        when(thngBuilder.list()).thenReturn(thngResult);
        when(thngResult.getResult()).thenReturn(new ArrayList<Thng>());
        Optional<List<Thng>> thngs = sensorRepository.getSensors();
        assertFalse(thngs.isPresent());
    }

    @Test
    public void testGetSensorsReturnsNull() throws Exception {
        when(thngService.thngsReader()).thenReturn(thngBuilder);
        when(thngBuilder.list()).thenReturn(thngResult);
        when(thngResult.getResult()).thenReturn(null);
        Optional<List<Thng>> thngs = sensorRepository.getSensors();
        assertFalse(thngs.isPresent());
    }

    @Test
    public void testGetProperty() throws Exception {
        when(thngService.propertyReader("1", "type")).thenReturn(propertyBuilder);
        when(propertyBuilder.execute()).thenReturn(Arrays.asList(MockPropertyBuilder.getMockProperty()));
        Optional<Property> property = sensorRepository.getLatestPropertyReading("1", "type");
        assertTrue(property.isPresent());
        Property result = property.get();
        assertThat(result.getId(), is("1"));
        assertThat(result.getValue(), is("mock"));
    }

    @Test
    public void testGetSensor() throws Exception {
        when(thngService.thngReader("1")).thenReturn(thngBuilder);
        when(thngBuilder.execute()).thenReturn(MockThngBuilder.getThng());
        Optional<Thng> thng = sensorRepository.getSensor("1");

        assertTrue(thng.isPresent());

        Thng result = thng.get();

        assertThat(result.getId(), is("1"));
        assertThat(result.getName(), is("Mock"));
    }

    @Test
    public void testGetSensorNullResponse() throws Exception {
        when(thngService.thngReader("1")).thenReturn(thngBuilder);
        when(thngBuilder.execute()).thenReturn(null);
        Optional<Thng> thng = sensorRepository.getSensor("1");

        assertFalse(thng.isPresent());
    }
}