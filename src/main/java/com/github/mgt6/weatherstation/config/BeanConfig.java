package com.github.mgt6.weatherstation.config;


import com.github.mgt6.weatherstation.repository.SensorRepository;
import com.github.mgt6.weatherstation.repository.impl.mock.MockSensorRepository;
import com.github.mgt6.weatherstation.service.SensorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean
    public SensorService sensorService() {
        return new SensorService();
    }

    @Bean
    public SensorRepository mockSensorRepository() {
        return new MockSensorRepository();
    }

    /*@Bean
    public SensorRepository evrythngSensorRepository() {
        return new EvrythngSensorRepository(new ApiManager("K6UxIsthLqChs6uc97SmZIEdiTHycaNiibDGSuyBox4RraMCzno3DZYWR5n6bmnJN0cAmZF12jFoZWlG"));
    }*/
}
