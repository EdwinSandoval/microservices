package com.example.serviceplazoleta.security.controller;

import com.example.serviceplazoleta.security.dto.AuthCredentials;
import com.example.serviceplazoleta.security.dto.LoginResponseDto;
import com.example.serviceplazoleta.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody AuthCredentials authCredentials){
        return LoginResponseDto
                .builder()
                .token(loginService.login(authCredentials))
                .build();
    }
}
