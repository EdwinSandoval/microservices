package com.example.serviceplazoleta.ConectionMicroservices.UserRestaurant;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuario-service",path = "/api/v1/user")
public interface IUserRestaurante {

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> obtenerUsuarios();

    @GetMapping
    public ResponseEntity<UserResponseDto> obtenerUsuarioId();

    @PostMapping
    public  ResponseEntity<List<UserResponseDto>> guardarUsuario(@RequestBody UserResponseDto userResponseDto);

    @PutMapping
    public ResponseEntity<Void> actualizarUsuario(@RequestBody UserResponseDto userResponseDto);

    @DeleteMapping("/{usuarioId")
    public ResponseEntity eliminarUsuarioId(@PathVariable String usuarioId);
}
