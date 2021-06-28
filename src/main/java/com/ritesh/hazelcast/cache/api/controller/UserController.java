package com.ritesh.hazelcast.cache.api.controller;


import com.ritesh.hazelcast.cache.api.model.User;
import com.ritesh.hazelcast.cache.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.delete(id);
    }


}
