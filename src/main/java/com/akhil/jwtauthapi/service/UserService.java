package com.akhil.jwtauthapi.service;

import com.akhil.jwtauthapi.dto.UpdateUserRequest;

public interface UserService {

    void updateUser(Long id, UpdateUserRequest request);

}