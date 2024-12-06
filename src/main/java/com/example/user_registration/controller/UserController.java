package com.example.user_registration.controller;

import com.example.user_registration.dto.UserPassDto;
import com.example.user_registration.repository.UserRepository;
import com.example.user_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public ResponseEntity<String> userRegistration(@RequestBody UserPassDto request){
        userService.register(request);
        return ResponseEntity.status(201).body("user registered successfully");
    }
}
