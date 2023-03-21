package com.example.serviceplazoleta.infraestructure.exceptionhandler;

import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//@ControllerAdvice
@RestControllerAdvice
public class ControllerAdvisor {

//    private static final String MESSAGE = "message";
//
//    @ExceptionHandler(NoDataFoundException.class)
//    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
//            NoDataFoundException ignoredNoDataFoundException) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
//    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidateException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<String,String >();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fielName=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            errors.put(fielName,message);
        });
        return errors;
    }
}
