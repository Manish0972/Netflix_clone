package com.netflixclone.netflixclone.service.impl;

import com.netflixclone.netflixclone.entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.netflixclone.netflixclone.dto.LoginDto;
import com.netflixclone.netflixclone.dto.RegisterDto;
import com.netflixclone.netflixclone.repository.UserRepository;
import com.netflixclone.netflixclone.security.JwtUtil;
import com.netflixclone.netflixclone.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection (Best Practice)
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
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

   @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(LoginDto dto) {
        user user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + dto.getEmail()));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return jwtUtil.generateToken(user.getEmail());  
    }
}