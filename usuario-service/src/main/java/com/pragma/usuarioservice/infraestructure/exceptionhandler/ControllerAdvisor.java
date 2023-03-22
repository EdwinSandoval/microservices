package com.pragma.usuarioservice.infraestructure.exceptionhandler;

import com.pragma.usuarioservice.infraestructure.exception.NoDataFoundException;
import com.pragma.usuarioservice.infraestructure.exception.ResponseJson.CustomException;
import com.pragma.usuarioservice.infraestructure.exception.ResponseJson.ResponseJson;
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

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomException.class)
    public ResponseJson customException(CustomException exception){
        return new ResponseJson("CustomException",exception.getMessage());
    }

//    private static final String MESSAGE = "message";

//    @ExceptionHandler(NoDataFoundException.class)
//    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
//            NoDataFoundException ignoredNoDataFoundException) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
//    }

//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> handleValidateException(MethodArgumentNotValidException ex){
//        Map<String,String> errors=new HashMap<String,String >();
//        ex.getBindingResult().getAllErrors().forEach((error)->{
//            String fielName=((FieldError) error).getField();
//            String message=error.getDefaultMessage();
//            errors.put(fielName,message);
//        });
//        return errors;
//    }
}
