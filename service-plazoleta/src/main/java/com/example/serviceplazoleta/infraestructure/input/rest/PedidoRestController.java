package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;
import com.example.serviceplazoleta.application.handler.IPedidoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedido")
@RequiredArgsConstructor
public class PedidoRestController {

    private final IPedidoHandler pedidoHandler;

    @PostMapping("/")
    public ResponseEntity<Void> guardarPedido(@RequestBody PedidoRequestDto pedidoRequestDto) {
        pedidoHandler.guardarPedido(pedidoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoResponseDto>> listarPedidos() {

        return ResponseEntity.ok(pedidoHandler.listarPedidos());
    }
}
