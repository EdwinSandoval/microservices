package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.UserRestaurante.UserRequestDto;
import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final IUserFeign iUserFeign;

    @PostMapping("/guardarPropietario")
    public ResponseEntity<Void> saveUserAsOwner(@Valid @RequestBody UserRequestDto userRequestDto){
//        try{
//            UserResponseDto userResponseDto = iUserFeign.obtenerEmail(userRequestDto.getEmail());
//        }
//        catch (Exception e){
            iUserFeign.guardarPropietario(userRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/guardarCliente")
    public ResponseEntity<Void> saveUserAsClient(@Valid @RequestBody UserRequestDto userRequestDto){
//        try{
//            UserResponseDto userResponseDto = iUserFeign.obtenerEmail(userRequestDto.getEmail());
//        }
//        catch (Exception e){
            iUserFeign.guardarCliente(userRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
