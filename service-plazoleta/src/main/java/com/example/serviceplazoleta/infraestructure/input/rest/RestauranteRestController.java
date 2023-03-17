package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.application.handler.IRestauranteHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurante")
@RequiredArgsConstructor
public class RestauranteRestController {

    private final IRestauranteHandler restauranteHandler;

    @PostMapping("/")
    public ResponseEntity<Void> guardarRestaurante(@RequestBody RestauranteRequestDto restauranteRequestDto) {
        restauranteHandler.guardarRestaurante(restauranteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<RestauranteResponseDto>> listarRestaurantes() {

        return ResponseEntity.ok(restauranteHandler.listarRestaurantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponseDto> getUserId(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(restauranteHandler.ObtenerRestauranteId(id));

    }
}
