package com.akhil.jwtauthapi.controller;

import com.akhil.jwtauthapi.entity.User;
import com.akhil.jwtauthapi.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akhil.jwtauthapi.dto.UserResponse;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.akhil.jwtauthapi.dto.RoleUpdateRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.akhil.jwtauthapi.dto.PasswordUpdateRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@RestController
public class AdminController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AdminController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("/api/admin/users")
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> {

                    UserResponse response = new UserResponse();

                    response.setId(user.getId());
                    response.setName(user.getName());
                    response.setEmail(user.getEmail());
                    response.setRole(user.getRole());

                    return response;

                })
                .collect(Collectors.toList());
    }

    @DeleteMapping("/api/admin/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(
            @PathVariable Long id
    ) {

        userRepository.deleteById(id);

        return "User Deleted";
    }

    @PutMapping("/api/admin/users/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateRole(

            @PathVariable Long id,

            @RequestBody RoleUpdateRequest request

    ) {

        User user = userRepository
                .findById(id)
                .orElseThrow();

        long adminCount = userRepository.countByRole("ADMIN");

        System.out.println("ADMIN COUNT = " + adminCount);
        System.out.println("CURRENT USER ROLE = " + user.getRole());
        System.out.println("REQUESTED ROLE = " + request.getRole());

        if (
                adminCount == 1
                        &&
                        user.getRole().equals("ADMIN")
                        &&
                        request.getRole().equals("USER")
        ) {
            System.out.println("BLOCKED LAST ADMIN DEMOTION");
            return "Cannot remove the last ADMIN";
        }

        user.setRole(request.getRole());

        userRepository.save(user);

        return "Role Updated";
    }

    @PutMapping("/api/admin/users/{id}/password")
    @PreAuthorize("hasRole('ADMIN')")
    public String updatePassword(

            @PathVariable Long id,

            @RequestBody PasswordUpdateRequest request

    ) {

        User user = userRepository
                .findById(id)
                .orElseThrow();

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        userRepository.save(user);

        return "Password Updated";
    }
}