package com.example.serviceplazoleta.infraestructure.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
//    private int code;
//    private String error;
    private String message;
//    private String path;
//    private Instant timestamp;
}
