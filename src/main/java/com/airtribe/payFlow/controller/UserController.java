package com.airtribe.payFlow.controller;

import com.airtribe.payFlow.entity.User;
import com.airtribe.payFlow.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /users
    @PostMapping
    public User registerUser(@RequestBody User user) {

        System.out.println(user);

        return userService.registerUser(user);
    }

    // GET /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // GET /users/upi/{upiId}
    @GetMapping("/upi/{upiId}")
    public User getUserByUpiId(@PathVariable String upiId) {
        return userService.findByUpiId(upiId);
    }
}
