package com.pragma.usuarioservice.infraestructure.security.impl;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import com.pragma.usuarioservice.infraestructure.security.IEncryptPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class EncryptPassword implements IEncryptPassword {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encryptPassword(String password) {
       return passwordEncoder.encode(password);
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hashPassword) {
        return false;
    }
}
