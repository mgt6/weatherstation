package com.github.mgt6.weatherstation.controller;

import com.github.mgt6.weatherstation.dto.SensorDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherStationController {

    @RequestMapping("/weatherStation")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        List<SensorDto> sensors = new ArrayList<SensorDto>();
        sensors.add(new SensorDto("1", "sensor1"));
        sensors.add(new SensorDto("2", "sensor2"));
        sensors.add(new SensorDto("3", "sensor3"));
        model.addAttribute("sensors", sensors);
        return "weatherStation";
    }
}







