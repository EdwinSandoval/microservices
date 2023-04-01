package com.example.serviceplazoleta.infraestructure.exception;

public class NoExisteElPropietario extends RuntimeException{
    public NoExisteElPropietario(String message) {
        super(message);
    }
}
