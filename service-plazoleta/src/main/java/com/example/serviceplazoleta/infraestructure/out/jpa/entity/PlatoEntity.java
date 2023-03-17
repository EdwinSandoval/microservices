package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plato")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class PlatoEntity {

    @Id
    @Column(name = "idPlato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private float precio;

    @Column
    private String urlImagen;

    @Column
    private String activo;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "idRestaurante")
    private RestauranteEntity restaurant;

    @OneToMany(mappedBy = "platos")
    private List<Pedido_PlatosEntity> pedidoPlatos;

    //idcategoria,idrestaurante
}
