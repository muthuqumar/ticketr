package com.cloudbees.ticketr.controller;

import com.cloudbees.ticketr.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        return new ArrayList<>();
    }
}