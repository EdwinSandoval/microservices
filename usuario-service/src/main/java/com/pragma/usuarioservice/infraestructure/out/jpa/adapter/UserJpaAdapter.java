package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.infraestructure.exception.NoDataFoundException;
import com.pragma.usuarioservice.infraestructure.exception.UserNameNotValidateException;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUsuarioPersistencePort {

    private final IUserRepository userRepository;

    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUsers(UsuarioModel usuarioModel) {
//        if (userRepository.findById(usuarioModel.getId()).isPresent()){
//            throw new UserAlreadyExistsException("Ya existe el usuario");
//        }
        if (usuarioModel.validarEmail() && usuarioModel.numeroTelefonoValido() && usuarioModel.dniValidate()){
            UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(usuarioModel));
            userEntityMapper.toUserModel(userEntity);
            return;
        }
        throw new UserNameNotValidateException("Usuario invalido");

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
        return userEntityMapper.toUserModel(userRepository.findById(idUser).get());
//                .orElseThrow(NoDataFoundException::new));
    }

    @Override
    public UsuarioModel getUserByEmail(String email) {
        return userEntityMapper.toUserModel(userRepository.findByEmail(email).get());
    }

}
