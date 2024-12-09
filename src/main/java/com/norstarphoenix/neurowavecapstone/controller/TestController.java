package com.norstarphoenix.neurowavecapstone.controller;

import com.norstarphoenix.neurowavecapstone.models.User; // Import User model
import com.norstarphoenix.neurowavecapstone.repositories.UserRepository; // Import UserRepository
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private final UserRepository userRepository;

    // Constructor for dependency injection
    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REST endpoint to fetch all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
