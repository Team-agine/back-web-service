package com.vehiculerental.backwebservice.controller;

import com.vehiculerental.backwebservice.model.User;
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
public class UsersController {

    /**
     *
     */
    @Autowired
    private RestTemplate restTemplate;

    private int retryCount = 0;

    @GetMapping(value = "/users")
    public String show(Model model) throws InterruptedException {
        List<User> users = new ArrayList<>();
        try {
            ResponseEntity<User[]> response = restTemplate.getForEntity("http://users-api/users", User[].class);
            model.addAttribute("users", Arrays.asList((User[]) response.getBody()));
        } catch (RestClientException e) {
            retryCount++;
            if (retryCount <= 3) {
                Thread.sleep(500);
                return show(model);
            }
            model.addAttribute("users", users);
        } catch (Exception e) {
            return e.getMessage();
        }

        retryCount = 0;
        return "user/show";
    }

    @GetMapping(value = "/users/new")
    public String showAddForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/add";
    }

    @PostMapping(value = "/users/new")
    public String checkUserInfo(@Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "user/add";
//        }
        restTemplate.postForObject("http://users-api/users", user, User.class);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/{id}")
    public String remove(@PathVariable String id) {
        String url = "http://users-api/users/" + id;
        restTemplate.delete(url);
        return "user/show";    }


    @RequestMapping(value = { "/updateusers/{id}" }, method = RequestMethod.GET)
    public String userModif(@PathVariable String id, Model model) {
        String url = "http://users-api/users/"+id;
        User user = restTemplate.getForObject(url, User.class);
        model.addAttribute("user", user);


        return "user/update";
    }

    @PostMapping(value = { "/modifUser/{id}" })
    public String modifUser(Model model, //
                           @ModelAttribute("user") User user, @PathVariable String id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request = new HttpEntity<User>(user, headers);
        String url = "http://users-api/users/" + id;
        restTemplate.put(url, request, User.class);

        return "redirect:/users";

    }
}
