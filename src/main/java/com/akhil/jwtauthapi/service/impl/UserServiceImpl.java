package com.akhil.jwtauthapi.service.impl;

import com.akhil.jwtauthapi.dto.UpdateUserRequest;
import com.akhil.jwtauthapi.entity.User;
import com.akhil.jwtauthapi.repository.UserRepository;
import com.akhil.jwtauthapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository
                .findById(id)
                .orElseThrow();

        user.setName(request.getName());

        userRepository.save(user);
    }
}