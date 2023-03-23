package com.pragma.usuarioservice.configuration.auth;

import com.pragma.usuarioservice.configuration.auth.Request.AuthenticationRequest;
import com.pragma.usuarioservice.configuration.auth.Request.RegisterRequest;
import com.pragma.usuarioservice.configuration.auth.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ){
//        return ResponseEntity.ok(service.register(request));
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> Atenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
