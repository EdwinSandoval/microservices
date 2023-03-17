package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "pedido_platos")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class Pedido_PlatosEntity {
    @Id
    @Column(name = "IdPedidoPlatos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPedidoPlatos;

    @Column
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idPlato",referencedColumnName = "idPlato")
    private PlatoEntity platos;

    @ManyToOne
    @JoinColumn(name = "idPedido",referencedColumnName = "idPedido")
    private PedidoEntity pedido;
}
