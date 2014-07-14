package com.github.mgt6.weatherstation.controller;

import com.github.mgt6.weatherstation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weatherStation")
public class WeatherStationController {

    @Autowired
    private SensorService sensorService;

    @RequestMapping
    public String sensors(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("sensors", sensorService.getSensors());
        return "weatherStation";
    }

    @RequestMapping("/sensor/{id}")
    public String reading(@PathVariable String id, String name, Model model) {
        model.addAttribute("sensor", sensorService.getSensor(id));
        model.addAttribute("reading", sensorService.getLatestSensorReading(id));
        return "sensor";
    }
}







