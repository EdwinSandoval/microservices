package com.pragma.usuarioservice.infraestructure.exception;

public class RolAlreadyExistsException extends RuntimeException{
    public RolAlreadyExistsException(String message) {
        super(message);
    }
}
