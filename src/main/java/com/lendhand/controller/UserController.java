package com.lendhand.controller;

import java.util.List;

import com.lendhand.model.Users;
import com.lendhand.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String home() {
        return "Hello world";
    }

    // add user
    @PostMapping("/add-user")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    // get list of users
    @GetMapping("/user")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user by id
    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    // update user by id
    @PutMapping("/user")
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }
}
