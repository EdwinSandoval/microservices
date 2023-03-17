package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.handler.ICategoriaHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
@RequiredArgsConstructor
public class CategoriaRestController {

    private final ICategoriaHandler categoriaHandler;

    @PostMapping("/guardar")
    public ResponseEntity<CategoriaResponseDto> guardarCategoria(@RequestBody CategoriaRequestDto categoriaRequestDto) {

        return new ResponseEntity<>( categoriaHandler.guardarCategoria(categoriaRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaResponseDto>> listarCategorias() {

        return ResponseEntity.ok(categoriaHandler.listarCategorias());
    }
}
