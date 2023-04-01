package com.pragma.usuarioservice.domain.exception;

public class NoEmailFound extends RuntimeException{
    public NoEmailFound(String message) {
        super("No existe el Email");
    }
}
