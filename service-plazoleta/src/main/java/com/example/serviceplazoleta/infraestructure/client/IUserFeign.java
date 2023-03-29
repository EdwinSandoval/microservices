package com.example.serviceplazoleta.infraestructure.client;

import com.example.serviceplazoleta.application.dto.request.UserRestaurante.UserRequestDto;
import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario-service",url = "localhost:8081/api/v1/user")
public interface IUserFeign {
    @GetMapping("/listar/{id}")
    public UserResponseDto obtenerIdUser(@PathVariable("id") Long id);

    @GetMapping("/username/{email}")
    public UserResponseDto obtenerEmail(@PathVariable("email") String email);

    @PostMapping("/guardarPropietario")
    public void guardarPropietario(@RequestBody UserRequestDto userRequestDto);

    @PostMapping("/guardarCliente")
    public void guardarCliente(@RequestBody UserRequestDto userRequestDto);

    @PostMapping("/guardarEmpleado")
    public void guardarEmpleado(@RequestBody UserRequestDto userRequestDto);

    @PostMapping("/guardarAdmin")
    public void guardarAdministrador(@RequestBody UserRequestDto userRequestDto);
}
