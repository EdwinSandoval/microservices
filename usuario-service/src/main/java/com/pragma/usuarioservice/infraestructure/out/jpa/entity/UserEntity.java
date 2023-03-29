package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
@Builder
public class UserEntity implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 30)
    private  String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;


    @Column(nullable = false, length = 13)
    private String celular;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;


    @Column( nullable = false)
    private String dni;//por preguntar

    @ManyToOne(cascade = CascadeType.MERGE, fetch =
            FetchType.EAGER)
    @JoinColumn(name = "idRol")//es el id que tiene la entidad rol
    private RolEntity rol;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMINISTRADOR"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
