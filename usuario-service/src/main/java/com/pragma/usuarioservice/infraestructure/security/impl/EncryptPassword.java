package com.pragma.usuarioservice.infraestructure.security.impl;

import lombok.RequiredArgsConstructor;
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
