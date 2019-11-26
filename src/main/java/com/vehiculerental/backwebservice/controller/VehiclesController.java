package com.vehiculerental.backwebservice.controller;


import com.vehiculerental.backwebservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class VehiclesController {

    /**
     *
     */
    @Autowired
    private RestTemplate restTemplate;

    private int retryCount = 0;

    @GetMapping(value = "/vehicles")
    public String show(Model model) throws InterruptedException {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            ResponseEntity<Vehicle[]> response = restTemplate.getForEntity("http://vehicles-api/vehicles", Vehicle[].class);
            model.addAttribute("vehicles", Arrays.asList((Vehicle[]) response.getBody()));
        } catch (RestClientException e) {
            retryCount++;
            if (retryCount <= 3) {
                Thread.sleep(500);
                return show(model);
            }
            model.addAttribute("vehicles", vehicles);
        } catch (Exception e) {
            return e.getMessage();
        }

        retryCount = 0;
        return "vehicle/show";
    }

    @GetMapping(value = "/vehicles/new")
    public String showAddForm(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle/add";
    }

    @PostMapping(value = "/vehicles/new")
    public String checkVehicleInfo(@Valid Vehicle vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vehicle/add";
        }
        restTemplate.postForObject("http://vehicles-api/vehicles", vehicle, Vehicle.class);
        return "redirect:/vehicles";
    }

    @DeleteMapping(value = "/vehicles/{id}")
    public String remove(@PathVariable Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://vehicles-api/vehicles" + id;
        restTemplate.delete(url);
        return "redirect:/vehicles";    }

}
