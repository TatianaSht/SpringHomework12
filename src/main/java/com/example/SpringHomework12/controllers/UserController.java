package com.example.SpringHomework12.controllers;

import com.example.SpringHomework12.domain.User;
import com.example.SpringHomework12.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }


    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user);
        return "User added from body!";
    }
}
