package com.vehiculerental.backwebservice.controller;

import com.vehiculerental.backwebservice.model.Booking;
import com.vehiculerental.backwebservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookingController {

    /**
     *
     */
    @Autowired
    private RestTemplate restTemplate;

    private int retryCount = 0;

    @GetMapping(value = "/bookings")
    public String show(Model model) throws InterruptedException {
        List<Booking> bookings = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            ResponseEntity<Booking[]> response = restTemplate.getForEntity("http://bookings-api/bookings", Booking[].class);
            model.addAttribute("bookings", Arrays.asList((Booking[]) response.getBody()));
        } catch (RestClientException e) {
            e.printStackTrace();
            retryCount++;
            if (retryCount <= 3) {
                Thread.sleep(500);
                return show(model);
            }
            model.addAttribute("bookings", bookings);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        retryCount = 0;
        return "booking/show";
    }

    @GetMapping(value = "/bookings/new")
    public String showAddForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "booking/add";
    }

    @PostMapping(value = "/bookings/new")
    public String checkBookingInfo(@Valid Booking booking, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "booking/add";
//        }
       ResponseEntity<Vehicle[]> response = restTemplate.postForEntity("http://bookings-api/bookings/vehicles-available", booking, Vehicle[].class);

        model.addAttribute("vehicles", Arrays.asList((Vehicle[]) response.getBody()));
        model.addAttribute("booking", booking );

        return "booking/addVehicleList";
    }

    @PostMapping(value = "/bookings/prepare")
    public String checkPrepareBookingInfo(@Valid Booking booking, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "booking/add";
//        }
        restTemplate.postForEntity("http://bookings-api/bookings/prepare", booking, Booking.class);


        return "redirect:/bookings";
    }

//    @DeleteMapping(value = "/bookings/{id}")
//    public String remove(@PathVariable String id) {
//        String url = "http://bookings-api/bookings/" + id;
//        restTemplate.delete(url);
//        return "booking/show";    }
//
//
//    @RequestMapping(value = { "/updatebookings/{id}" }, method = RequestMethod.GET)
//    public String bookingModif(@PathVariable String id, Model model) {
//        String url = "http://bookings-api/bookings/"+id;
//        Booking booking = restTemplate.getForObject(url, Booking.class);
//        model.addAttribute("booking", booking);
//
//
//        return "booking/update";
//    }
//
//    @PostMapping(value = { "/modifBooking/{id}" })
//    public String modifBooking(Model model, //
//                            @ModelAttribute("booking") Booking booking, @PathVariable String id) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Booking> request = new HttpEntity<Booking>(booking, headers);
//        String url = "http://bookings-api/bookings/" + id;
//        restTemplate.put(url, request, Booking.class);
//
//        return "redirect:/bookings";
//
//    }
}
