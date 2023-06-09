package com.pragma.usuarioservice.application.handler;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {
    void saveUsers(UserRequestDto userRequestDto,Long idRol);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserId(Long idUser);

    UserResponseDto getEmail(String email);

}
