package com.github.mgt6.weatherstation.config;


import com.github.mgt6.weatherstation.repository.EvrythngSensorRepository;
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
    public EvrythngSensorRepository evrythngSensorRepository() {
        return new EvrythngSensorRepository();
    }
}
