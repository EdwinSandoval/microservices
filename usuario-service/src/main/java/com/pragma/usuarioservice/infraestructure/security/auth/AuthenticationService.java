package com.pragma.usuarioservice.infraestructure.security.auth;

import com.pragma.usuarioservice.infraestructure.security.JwtService;
import com.pragma.usuarioservice.infraestructure.security.auth.Request.AuthenticationRequest;
import com.pragma.usuarioservice.infraestructure.security.auth.Response.AuthenticationResponse;
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


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =repository.findByEmail(request.getEmail())
                .orElseThrow();
        var rol=user.getRol().getNombre();

        var jwtToken=jwtService.generateToken(user,rol);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
//    private Optional<UserEntity> optionalDetailsUser(String username) {
//        UserResponseDto userResponseDto = repository.findByEmail(username);
//        UserEntity userEntity = use.toUser(userResponseDto);
//        user.setRol(userResponseDto.getRol().getNombre());
//        return Optional.of(user);//retorna el usuario buscado
//    }



}
