package com.skillsync.backend.controller;

import com.skillsync.backend.DTO.AuthResponse;
import com.skillsync.backend.DTO.RegisterRequest;
import com.skillsync.backend.entity.User;
import com.skillsync.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userService.registerUser(user);

        return new AuthResponse("User registered successfully!");
    }
}