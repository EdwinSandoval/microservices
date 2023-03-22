package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plato")
@RequiredArgsConstructor
public class PlatoRestController {

    private final IPlatoHandler platoHandler;

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarPlato(@RequestBody  PlatoRequestDto platoRequestDto) {

        platoHandler.guardarPlato(platoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PlatoResponseDto>> listarPlatos() {

        return ResponseEntity.ok(platoHandler.listarPlatos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<BuscarPlatoIdResponseDto> buscarPlatoId(@PathVariable(name = "id") Long platoId){
        return ResponseEntity.ok(platoHandler.buscarPlatoId(platoId));
    }


    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarPlato(@RequestBody ActualizarPlatoRequest actualizarPlatoRequest){
        platoHandler.actualizarPlato(actualizarPlatoRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
