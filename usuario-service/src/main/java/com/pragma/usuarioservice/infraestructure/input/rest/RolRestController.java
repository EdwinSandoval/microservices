package com.pragma.usuarioservice.infraestructure.input.rest;

import com.pragma.usuarioservice.application.dto.request.RolRequestDto;
import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.RolResponseDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.application.handler.IRolHandler;
import com.pragma.usuarioservice.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RolRestController {

    private final IRolHandler rolHandler;

    @PostMapping("/")
    public ResponseEntity<Void> saveRol(@RequestBody RolRequestDto rolRequestDto) {
        rolHandler.saveRols(rolRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<RolResponseDto>> getAllRols() {
        String palabra="+985645";
        System.out.println(palabra.substring(0,1)+" tamaño="+palabra.length()+" sub 0 a tamaño="+palabra.substring(0,palabra.length()));
        return ResponseEntity.ok(rolHandler.getAllRols());
    }
}
