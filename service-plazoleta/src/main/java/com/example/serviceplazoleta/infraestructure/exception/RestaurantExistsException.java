package com.example.serviceplazoleta.infraestructure.exception;

public class RestaurantExistsException extends RuntimeException{
    public RestaurantExistsException(String message) {
        super(message);
    }
}
