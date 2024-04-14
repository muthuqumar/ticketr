package com.cloudbees.ticketr.controller;

import com.cloudbees.ticketr.model.User;
import com.cloudbees.ticketr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
