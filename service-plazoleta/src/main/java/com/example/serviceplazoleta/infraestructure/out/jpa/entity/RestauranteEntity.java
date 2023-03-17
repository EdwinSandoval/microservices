package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurante")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private String telefono;

    @Column
    private String urlLogo;

    @Column
    private String nit;

    @Column
    private  Long idPropietario;//

    @OneToMany(mappedBy = "restaurant")
    private List<PedidoEntity> pedido;

    @OneToMany(mappedBy = "restaurant")//la variable q esta dentro es la que se creo en la entidad usuario
    private List<PlatoEntity> platos;
    //idpropietario
}
