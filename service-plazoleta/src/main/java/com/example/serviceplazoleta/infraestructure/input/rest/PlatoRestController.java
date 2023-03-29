package com.example.serviceplazoleta.infraestructure.input.rest;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarEstadoPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.Plato.PlatoPaginadoResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ListarRestauranteResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PostMapping("/guardar/{idProp}")
    public ResponseEntity<Void> guardarPlato(@RequestBody  PlatoRequestDto platoRequestDto,@PathVariable(name = "idProp")  Long idProp) {

        platoHandler.guardarPlato(idProp,platoRequestDto);
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


    @PutMapping("/actualizar/{idProp}")
    public ResponseEntity<Void> actualizarPlato(@RequestBody ActualizarPlatoRequest actualizarPlatoRequest,@PathVariable(name = "idProp") Long idProp){
        platoHandler.actualizarPlato(actualizarPlatoRequest,idProp);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/actualizarEstado/{idProp}")
    public ResponseEntity<Void> actualizarEstadoPlato(@RequestBody ActualizarEstadoPlatoRequest estadoPlato, @PathVariable(name = "idProp") Long idProp){
        platoHandler.actualizarEstadoPlato(estadoPlato,idProp);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listarTodos/{idRest}/{elementosPorPag}/{numeroPag}")
    public ResponseEntity<List<PlatoPaginadoResponseDto>> listarPlatosPaginados(
            @PathVariable("idRest") Long idRest,
            @PathVariable("numeroPag") Integer numeroPag,
            @PathVariable("elementosPorPag") Integer elementosPorPag
    ) {

        return ResponseEntity.ok(platoHandler.listarPlatosPaginados(idRest,numeroPag,
                elementosPorPag));
    }
}
