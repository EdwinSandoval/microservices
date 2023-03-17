package com.pragma.usuarioservice.application.handler;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {
    UserResponseDto saveUsers(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserId(Long idUser);

}
