package com.pragma.usuarioservice.infraestructure.input.rest;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.application.handler.IUserHandler;
import com.pragma.usuarioservice.infraestructure.exception.ResponseJson.CustomException;
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

//    @Operation(summary = "Add a new object")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
//            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
//    })
//    @PostMapping("/guardar")
//    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto,Errors errors) {
//        if (errors.hasErrors()){
//            throwError(errors);
//        }
//        userHandler.saveUsers(userRequestDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PostMapping("/guardarPropietario")
    public ResponseEntity<Void> saveUserPropietary(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
        userHandler.saveUsers(userRequestDto,2L);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/guardarCliente")
    public ResponseEntity<Void> saveUserClient(@Validated @RequestBody UserRequestDto userRequestDto, Errors errors) {
        if (errors.hasErrors()){
            throwError(errors);
        }
//        if (idRol.equals(3)){
        userHandler.saveUsers(userRequestDto,3L);
        return new ResponseEntity<>(HttpStatus.CREATED);
//        }
    }

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



//    @Operation(summary = "Get all objects")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "All objects returned",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
//            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
//    })
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
