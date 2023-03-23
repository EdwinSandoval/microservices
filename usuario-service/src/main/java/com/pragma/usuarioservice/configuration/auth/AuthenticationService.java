package com.pragma.usuarioservice.configuration.auth;

import com.pragma.usuarioservice.configuration.JwtService;
import com.pragma.usuarioservice.configuration.auth.Request.AuthenticationRequest;
import com.pragma.usuarioservice.configuration.auth.Request.RegisterRequest;
import com.pragma.usuarioservice.configuration.auth.Response.AuthenticationResponse;
import com.pragma.usuarioservice.infraestructure.exception.UserAlreadyExistsException;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

        var user= UserEntity.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
//                .celular(request.get)
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
//                .rol(RolEntity())
                .build();

//                .dni()
//                .rol()
//        repository.findById(user.getId());
        var user2 =repository.findByEmail(request.getEmail());
        if (user2.isPresent()){
            var jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
//            throw new UserAlreadyExistsException("Usuario Existe");
        }
        else {
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }




}
