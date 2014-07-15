package com.github.mgt6.weatherstation.controller;

import com.github.mgt6.weatherstation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Basic MVC controller providing the data models to the views for rendering.
 */
@Controller
@RequestMapping("/weatherStation")
public class WeatherStationController {

    /**
     * The service to use to get sensor information.
     */
    @Autowired
    private SensorService sensorService;

    /**
     * Gets a list of sensors for this application.
     *
     * @param model the model to populate.
     * @return The view to render.
     */
    @RequestMapping
    public String sensors(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("sensors", sensorService.getSensors());
        return "weatherStation";
    }

    /**
     * Creates a model for a single sensor object.
     *
     * @param id The id of the sensor.
     * @param model The model to populate.
     * @return The view to render.
     */
    @RequestMapping("/sensor/{id}")
    public String reading(@PathVariable String id, String name, Model model) {
        model.addAttribute("sensor", sensorService.getSensor(id));
        model.addAttribute("reading", sensorService.getLatestSensorReading(id));
        model.addAttribute("readings", sensorService.getSensorReadings(id));
        return "sensor";
    }
}







