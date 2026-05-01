package com.netflixclone.netflixclone.controller;

import com.netflixclone.netflixclone.dto.RegisterDto;
import com.netflixclone.netflixclone.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController  {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterDto dto) {

        return authService.register(dto);
    }

}