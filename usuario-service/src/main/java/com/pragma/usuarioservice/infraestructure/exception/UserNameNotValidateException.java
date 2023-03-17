package com.pragma.usuarioservice.infraestructure.exception;

public class UserNameNotValidateException extends RuntimeException{
    public UserNameNotValidateException(String message) {
        super(message);
    }
}
