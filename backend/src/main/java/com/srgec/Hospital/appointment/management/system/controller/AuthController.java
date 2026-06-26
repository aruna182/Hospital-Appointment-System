package com.srgec.Hospital.Appointment.Management.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.srgec.Hospital.Appointment.Management.System.dto.AuthResponse;
import com.srgec.Hospital.Appointment.Management.System.dto.LoginRequest;
import com.srgec.Hospital.Appointment.Management.System.model.User;
import com.srgec.Hospital.Appointment.Management.System.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        return userService.login(request);
    }
}