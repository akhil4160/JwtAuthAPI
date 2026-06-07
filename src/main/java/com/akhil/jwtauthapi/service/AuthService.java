package com.akhil.jwtauthapi.service;

import com.akhil.jwtauthapi.dto.AuthResponse;
import com.akhil.jwtauthapi.dto.LoginRequest;
import com.akhil.jwtauthapi.dto.RegisterRequest;

public interface AuthService {

    String testService();

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}