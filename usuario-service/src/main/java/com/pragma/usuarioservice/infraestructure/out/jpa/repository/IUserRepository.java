package com.pragma.usuarioservice.infraestructure.out.jpa.repository;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    //estos metodos son para buscar por otro atributo que no sea el id

    Optional<UserEntity> findByEmail(String email);
//
//    Boolean selectExistsEmail(String email);
//    UsuarioModel findByIdUser(Long id);

}
