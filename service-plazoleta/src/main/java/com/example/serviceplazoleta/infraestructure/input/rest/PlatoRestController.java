package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plato")
@RequiredArgsConstructor
public class PlatoRestController {

    private final IPlatoHandler platoHandler;

    @PostMapping("/")
    public ResponseEntity<Void> guardarPlato(@RequestBody PlatoRequestDto platoRequestDto) {
        platoHandler.guardarPlato(platoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PlatoResponseDto>> listarPlatos() {

        return ResponseEntity.ok(platoHandler.listarPlatos());
    }
}
