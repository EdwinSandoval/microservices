package com.pragma.usuarioservice.domain.spi;

import com.pragma.usuarioservice.domain.model.UsuarioModel;

import java.util.List;

public interface IUsuarioPersistencePort {

    UsuarioModel saveUsers(UsuarioModel usuarioModel);

    List<UsuarioModel> getAllUsers();

    UsuarioModel getUserId(Long idUser);



    //void deleteUser(Long idUser);

//    void updateUser(UsuarioModel usuarioModel);

}
