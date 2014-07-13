package com.github.mgt6.weatherstation.controller;

import com.github.mgt6.weatherstation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherStationController {

    @Autowired
    private SensorService sensorService;

    @RequestMapping("/weatherStation")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("sensors", sensorService.getSensors());
        return "weatherStation";
    }
}







