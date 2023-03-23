package com.pragma.usuarioservice.domain.api;

import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.domain.model.UsuarioModel;

import java.util.List;

public interface IUsuarioServicePort {

    UsuarioModel saveUsers(UsuarioModel usuarioModel,Long idRol);

    List<UsuarioModel> getAllUsers();

    UsuarioModel getUserId(Long idUser);


    //void deleteUser(Long idUser);

//    void updateUser(UsuarioModel usuarioModel);
}
