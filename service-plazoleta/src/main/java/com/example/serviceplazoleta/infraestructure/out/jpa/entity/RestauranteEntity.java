package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Column(name = "idRestaurante")
    private Long idRestaurante;

    @Column( nullable = false, length = 30)
    private String nombre;

    @Column( nullable = false, length = 50)
    private String direccion;

    @Column( nullable = false, length = 13)
    private String telefono;

    @Column( nullable = false, length = 100)
    private String urlLogo;

    @Column( nullable = false, length = 11)
    private String nit;

    @Column( nullable = false)
    private  Long idPropietario;//

    @OneToMany(mappedBy = "restaurant")
    private List<PedidoEntity> pedido;

    @OneToMany(mappedBy = "restaurant")//la variable q esta dentro es la que se creo en la entidad usuario
    private List<PlatoEntity> platos;

}
