package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.api.IPedidoServicePort;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoEntityMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistencePort pedidoPersistencePort;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final IUserFeign iUserFeign;

    public PedidoUseCase(IPedidoPersistencePort pedidoPersistencePort, IPedidoEntityMapper pedidoEntityMapper, IUserFeign iUserFeign) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.pedidoEntityMapper = pedidoEntityMapper;
        this.iUserFeign = iUserFeign;
    }

    @Override
    public void guardarPedido(PedidoModel pedidoModel) {

        UserResponseDto userResponseDtoCliente;
        UserResponseDto userResponseDtoChef;
        userResponseDtoCliente=iUserFeign.obtenerIdUser(pedidoModel.getIdCliente());
        userResponseDtoChef=iUserFeign.obtenerIdUser(pedidoModel.getIdChef());

        if ((!userResponseDtoCliente.getRol().getNombre().equals("CLIENTE")) ||(!userResponseDtoChef.getRol().getNombre().equals("EMPLEADO")) ){
            throw new RuntimeException("No existe el Cliente o Chef Ingresado");
        }
        pedidoModel.setEstado("Pendiente");
        pedidoModel.setFecha(new Date());
        PedidoEntity pedidoEntity=pedidoEntityMapper.toEntity(pedidoModel);
        pedidoPersistencePort.guardarPedido(pedidoModel);
    }

        @Override
        public List<PedidoModel> listarPedidos() {
            return pedidoPersistencePort.listarPedidos();
        }
}
