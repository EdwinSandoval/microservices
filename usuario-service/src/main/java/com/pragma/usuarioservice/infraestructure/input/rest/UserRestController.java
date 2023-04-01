package com.pragma.usuarioservice.infraestructure.input.rest;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.application.handler.IUserHandler;
import com.pragma.usuarioservice.infraestructure.exception.ResponseJson.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Guardar un nuevo  Administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Adminstrador creado", content = @Content),
    })

    @PostMapping("/guardarAdmin")
    public ResponseEntity<Void> saveUserAdmin(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
        userHandler.saveUsers(userRequestDto,1L);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Guardar un nuevo  Propietario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Propietario creado", content = @Content),
    })
    @PostMapping("/guardarPropietario")
    public ResponseEntity<Void> saveUserPropietary(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
        userHandler.saveUsers(userRequestDto,2L);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Guardar un nuevo  Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado", content = @Content),
    })
    @PostMapping("/guardarCliente")
    public ResponseEntity<Void> saveUserClient(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
        userHandler.saveUsers(userRequestDto,3L);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @Operation(summary = "Guardar un nuevo  Empleado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empleado creado", content = @Content),
    })
    @PostMapping("/guardarEmpleado")
    public ResponseEntity<Void> saveUserEmployee(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
//        if (idRol.equals(3)){
            userHandler.saveUsers(userRequestDto,4L);
            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userHandler.getAllUsers());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userHandler.getUserId(userId));
    }

    @GetMapping("/username/{email}")
    public ResponseEntity<UserResponseDto> getEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(userHandler.getEmail(email));
    }


    public void throwError(Errors errors){
        String mensaje="";
        int index=0;
        for (ObjectError r:errors.getAllErrors()){
            if (index>0){
                mensaje+=" | ";
            }
            mensaje+=String.format("Parametro: %s - Mensaje: %s",r.getObjectName(),r.getDefaultMessage());
        }
        throw new CustomException(mensaje);
    }

}
