package com.pragma.usuarioservice.application.handler.impl;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.application.handler.IUserHandler;
import com.pragma.usuarioservice.application.mapper.IUserRequestMapper;
import com.pragma.usuarioservice.application.mapper.IUserResponseMapper;
import com.pragma.usuarioservice.domain.api.IUsuarioServicePort;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional//hace un roolback
public class UserHandler implements IUserHandler {

    private final IUsuarioServicePort usuarioServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(usuarioServicePort.getAllUsers());
    }

    @Override
    public UserResponseDto getUserId(Long idUser) {
        UsuarioModel usuarioModel=usuarioServicePort.getUserId(idUser);
        return userResponseMapper.toResponse(usuarioModel);
    }


//    @Override
//    public RestauranteModel saveRestaurante(Long id, RestauranteModel restauranteModel) {
//        return null;
//    }

    @Override
    public UserResponseDto saveUsers(UserRequestDto userRequestDto) {
        UsuarioModel usuarioModel = userRequestMapper.toUser(userRequestDto);
        return userResponseMapper.toResponse(usuarioServicePort.saveUsers(usuarioModel));
    }
//
//    @Override
//    public List<UserResponseDto> getAllUsers() {
//        return userResponseMapper.toResponseList(usuarioServicePort.getAllUsers());
//    }



}
