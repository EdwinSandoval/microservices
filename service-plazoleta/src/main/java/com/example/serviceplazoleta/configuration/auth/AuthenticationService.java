package com.example.serviceplazoleta.configuration.auth;

import com.example.serviceplazoleta.configuration.JwtService;
import com.example.serviceplazoleta.configuration.auth.Request.AuthenticationRequest;
import com.example.serviceplazoleta.configuration.auth.Response.AuthenticationResponse;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.Usuario.IUsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    private final IUserFeign iUserFeign;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
//        var user=iUserFeign.obtenerId(request.getEmail()):
        var user =repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken((UserDetails) user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
