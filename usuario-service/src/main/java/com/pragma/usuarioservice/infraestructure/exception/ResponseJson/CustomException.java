package com.pragma.usuarioservice.infraestructure.exception.ResponseJson;

public class CustomException extends RuntimeException {
    public CustomException(String msg){
        super(msg);
    }

}
