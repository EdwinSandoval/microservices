package com.example.serviceplazoleta.infraestructure.client;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service",url = "localhost:8081/api/v1/user")
public interface IUserFeign {
    @GetMapping("/listar/{id}")
    public UserResponseDto obtenerId(@PathVariable Long id);

}
