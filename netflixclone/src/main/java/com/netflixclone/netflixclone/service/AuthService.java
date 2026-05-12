package com.netflixclone.netflixclone.service;

import com.netflixclone.netflixclone.dto.LoginDto;
import com.netflixclone.netflixclone.dto.RegisterDto;

public interface AuthService {
     String register(RegisterDto dto);

     String login(LoginDto dto);
     

}
