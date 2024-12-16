package com.example.user_registration.controller;

import com.example.user_registration.dto.UserPassDto;
import com.example.user_registration.entity.Users;
import com.example.user_registration.exceptions.UserNotFoundException;
import com.example.user_registration.repository.UserRepository;
import com.example.user_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public ResponseEntity<String> userRegistration(@RequestBody UserPassDto request){
        userService.register(request);
        return ResponseEntity.status(201).body("user registered successfully");
    }

    // Add this endpoint to fetch user by username
    @GetMapping("/users/{userName}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String userName) {
        try {
            Users user = userService.findByUsername(userName);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage()); // User not found
        }
    }
}
