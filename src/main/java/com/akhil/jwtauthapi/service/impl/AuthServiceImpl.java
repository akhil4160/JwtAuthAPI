package com.akhil.jwtauthapi.service.impl;

import com.akhil.jwtauthapi.dto.AuthResponse;
import com.akhil.jwtauthapi.dto.LoginRequest;
import com.akhil.jwtauthapi.dto.RegisterRequest;
import com.akhil.jwtauthapi.service.AuthService;
import org.springframework.stereotype.Service;
import com.akhil.jwtauthapi.entity.User;
import com.akhil.jwtauthapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.akhil.jwtauthapi.util.JwtUtil;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;


    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String testService() {

        return "Auth Service Working";

    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        user.setRole("USER");

        userRepository.save(user);

        return new AuthResponse("User Registered Successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        boolean isPasswordCorrect =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}