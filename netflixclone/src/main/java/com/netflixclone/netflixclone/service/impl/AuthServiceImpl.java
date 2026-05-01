package com.netflixclone.netflixclone.service.impl;

import com.netflixclone.netflixclone.entity.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.netflixclone.netflixclone.dto.RegisterDto;
import com.netflixclone.netflixclone.repository.UserRepository;
import com.netflixclone.netflixclone.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection (Best Practice)
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(RegisterDto dto) {

        // Optional: Check if user already exists
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Create new user
        user user = new user();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // Default role
        user.setRole("ROLE_USER");

        // Save to DB
        userRepository.save(user);

        return "User registered successfully";
    }
}