package com.github.mgt6.weatherstation.repository;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.core.EvrythngApiBuilder.Builder;
import com.evrythng.java.wrapper.service.ThngService;
import com.evrythng.thng.resource.model.store.Thng;
import com.github.mgt6.weatherstation.mock.MockThngBuilder;
import com.github.mgt6.weatherstation.repository.impl.evrythng.EvrythngSensorRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

    private Builder.Result thngResult = mock(Builder.Result.class);

    @Before
    public void setUp() throws Exception {
        when(api.thngService()).thenReturn(thngService);
        sensorRepository = new EvrythngSensorRepository(api);
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
}