package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.PedidoPlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoPlatoResponseDto;

import com.example.serviceplazoleta.application.handler.IPedidoPlatoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidoPlato")
@RequiredArgsConstructor
public class PedidoPlatoRestController {
    private final IPedidoPlatoHandler pedidoPlatoHandler;

    @PostMapping("/guardar/{idRestaurante}/{idCliente}/{idEmpleado}")
    public ResponseEntity<Void> guardarPedidoPlato(
            @RequestBody PedidoPlatoRequestDto pedidoPlatoRequestDto

            ) {
        pedidoPlatoHandler.guardarPedidoPlato(pedidoPlatoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PedidoPlatoResponseDto>> listarPedidos() {
        return ResponseEntity.ok(pedidoPlatoHandler.listarPedidos());
    }
}
