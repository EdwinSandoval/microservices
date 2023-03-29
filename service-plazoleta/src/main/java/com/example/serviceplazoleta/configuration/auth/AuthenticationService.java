package com.example.serviceplazoleta.configuration.auth;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.configuration.JwtService;
import com.example.serviceplazoleta.configuration.auth.Details.DetailsUser;
import com.example.serviceplazoleta.configuration.auth.Details.IDetailsUserMapper;
import com.example.serviceplazoleta.configuration.auth.Request.AuthenticationRequest;
import com.example.serviceplazoleta.configuration.auth.Response.AuthenticationResponse;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

//    private final IUsuarioRepository repository;
//    private final PasswordEncoder passwordEncoder;
    private final IDetailsUserMapper userDetailsMapper;
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
        var user=optionalDetailsUser(request.getEmail()).get();
        var jwtToken=jwtService.generateToken(user,user.getRol() );

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private Optional<DetailsUser> optionalDetailsUser(String username) {
        UserResponseDto userResponseDto = iUserFeign.obtenerEmail(username);
        DetailsUser user = userDetailsMapper.toUser(userResponseDto);
        user.setRol(userResponseDto.getRol().getNombre());
        return Optional.of(user);//retorna el usuario buscado
    }

//    public UserAuthDto getUserAuth(String email) {
//        UserResponseDto userResponseDto;
//        try{
//            userResponseDto = iUserFeign.obtenerEmail(email);
//        }
//        catch (Exception e){
//            throw new RuntimeException();
//        }
//        DetailsUser user = userDetailsMapper.toUser(userResponseDto);
//        user.setRole(userResponseDto.getRole().getName());
//
//        return userDetailsMapper.toUserAuth(user);
//    }
}
