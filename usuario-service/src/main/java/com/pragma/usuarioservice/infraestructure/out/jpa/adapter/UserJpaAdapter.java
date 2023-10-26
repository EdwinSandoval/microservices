package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.exception.NoEmailFound;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.infraestructure.exception.NoDataFoundException;
import com.pragma.usuarioservice.infraestructure.exception.UserAlreadyExistsException;
import com.pragma.usuarioservice.infraestructure.exception.UserNameNotValidateException;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUsuarioPersistencePort {

    private final IUserRepository userRepository;

    private final IUserEntityMapper userEntityMapper;

    @Override
    public UsuarioModel saveUsers(UsuarioModel usuarioModel) {

//        if (userRepository.findByEmail(usuarioModel.getEmail()).isPresent()){
//            throw new UserAlreadyExistsException("Ya existe el usuario");
//        }

        UserEntity userEntity=userRepository.save(userEntityMapper.toEntity(usuarioModel));
        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public List<UsuarioModel> getAllUsers() {
        List<UserEntity> entityList = userRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserModelList(entityList);
    }

    @Override
    public UsuarioModel getUserId(Long idUser) {
        return userEntityMapper.toUserModel(userRepository.findById(idUser)
                .orElseThrow(NoDataFoundException::new));
    }

    @Override
    public UsuarioModel getEmail(String email) {
        Optional<UserEntity> entity=userRepository.findByEmail(email);
        if (entity.isPresent()){
            return userEntityMapper.toUserModel(entity.get());
        }
//        return userEntityMapper.toUserModel(entity
//                .orElseThrow(NoDataFoundException::new));
        return null;
    }

}
