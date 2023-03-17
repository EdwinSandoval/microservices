package com.pragma.usuarioservice.infraestructure.configuration;

import com.pragma.usuarioservice.domain.api.IRolServicePort;
import com.pragma.usuarioservice.domain.api.IUsuarioServicePort;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.domain.usecase.RolUseCase;
import com.pragma.usuarioservice.domain.usecase.UsersUseCase;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.RolJpaAdapter;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IRolRepository;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import com.pragma.usuarioservice.infraestructure.security.IEncryptPassword;
import com.pragma.usuarioservice.infraestructure.security.impl.EncryptPassword;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    //para users
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    //para rol
    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Bean
    public IUsuarioPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUsuarioServicePort usuarioServicePort() {
        return new UsersUseCase(userPersistencePort(),encryptPassword());
    }

    @Bean
    public IRolPersistencePort rolPersistencePort() {

        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolServicePort() {

        return new RolUseCase(rolPersistencePort());
    }

    @Bean
    public PasswordEncoder encoder() { return new BCryptPasswordEncoder();}

    public IEncryptPassword encryptPassword(){
        return new EncryptPassword(encoder());
    }


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return  new BasicAuthRequestInterceptor( "usuario" , "contraseña" );
    }
//    @Bean
//    public RequestInterceptor securityFeignRequestInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate template) {
//                return;
//            }
//        };
//    }
}
