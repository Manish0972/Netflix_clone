package com.netflixclone.netflixclone.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDto {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email; 
    
    @NotBlank(message = "Password is required")
    private String password;

    public LoginDto() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    


}
