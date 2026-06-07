package com.akhil.jwtauthapi.controller;

import com.akhil.jwtauthapi.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akhil.jwtauthapi.dto.AuthResponse;
import com.akhil.jwtauthapi.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.akhil.jwtauthapi.dto.LoginRequest;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/api/test")
    public String test() {
        return authService.testService();
    }

    @PostMapping("/api/auth/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/api/auth/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}