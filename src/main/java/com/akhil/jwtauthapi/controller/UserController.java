package com.akhil.jwtauthapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/user/me")
    public Map<String, Object> currentUser(
            Authentication authentication
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("email", authentication.getName());
        response.put("roles", authentication.getAuthorities());

        return response;
    }
}