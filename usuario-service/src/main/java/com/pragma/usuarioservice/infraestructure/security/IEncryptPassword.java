package com.pragma.usuarioservice.infraestructure.security;

public interface IEncryptPassword {

    String encryptPassword(String password);//encripta la contraseña que recibe

    boolean verifyPassword(String originalPassword,String hashPassword);//verificamos contraseña real con encriptada

}
