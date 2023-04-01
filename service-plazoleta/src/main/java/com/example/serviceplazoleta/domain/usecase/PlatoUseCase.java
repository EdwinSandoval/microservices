package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;

    private final IPlatoRepository platoRepository;
    private final ICategoriaRepository categoriaRepository;
    private final IRestauranteRepository restauranteRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final ICategoriaEntityMapper categoriaEntityMapper;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final IUserFeign iUserFeign;

    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort, IPlatoRepository platoRepository,
                        ICategoriaRepository categoriaRepository, IRestauranteRepository restauranteRepository,
                        IPlatoEntityMapper platoEntityMapper, ICategoriaEntityMapper categoriaEntityMapper,
                        IRestauranteEntityMapper restauranteEntityMapper, IUserFeign iUserFeign) {
        this.platoPersistencePort = platoPersistencePort;
        this.platoRepository = platoRepository;
        this.categoriaRepository = categoriaRepository;
        this.restauranteRepository = restauranteRepository;
        this.platoEntityMapper = platoEntityMapper;
        this.categoriaEntityMapper = categoriaEntityMapper;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.iUserFeign = iUserFeign;
    }

    //    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort) {
//        this.platoPersistencePort = platoPersistencePort;
//    }

    @Override
    public PlatoModel guardarPlato(Long idProp,PlatoModel platoModel) {
        platoModel.setActivo(true);
        PlatoEntity platoEntity=platoEntityMapper.toEntity(platoModel);
        CategoriaEntity categoria = categoriaRepository.findByIdCategoria(platoModel.getCategoria().getIdCategoria());
        RestauranteEntity restaurante = restauranteRepository.findByIdRestaurante(platoModel.getRestaurant().getIdRestaurante());
        Long idPropietario = restaurante.getIdPropietario();

        if (categoria.getIdCategoria()!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)) {
            platoEntity.setCategoria(categoria);
            platoEntity.setRestaurant(restaurante);
            return platoEntityMapper.toPlatoModel(platoRepository.save(platoEntity));

        }
        throw new NoDataFoundException();

//        return  platoPersistencePort.guardarPlato(idProp,platoModel);
    }

    @Override
    public List<PlatoModel> listarPlatos() {

        return platoPersistencePort.listarPlatos();
    }

    @Override
    public void actualizarPlato(PlatoModel platoModel, Long idProp) {
        PlatoModel platoAntiguo=platoPersistencePort.buscarPlatoId(platoModel.getId());
        RestauranteEntity restaurante = restauranteRepository.findByIdRestaurante(platoAntiguo.getRestaurant().getIdRestaurante());
        Long idPropietario = restaurante.getIdPropietario();

        if (platoAntiguo!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)){

            PlatoModel platoModelNew=new PlatoModel();

            platoModel.setId(platoAntiguo.getId());
            platoModel.setNombre(platoAntiguo.getNombre());
            platoModel.setPrecio(platoModel.getPrecio());
            platoModel.setDescripcion(platoModel.getDescripcion());
            platoModel.setUrlImagen(platoAntiguo.getUrlImagen());
            platoModel.setActivo(platoAntiguo.isActivo());
            platoModel.setCategoria(platoAntiguo.getCategoria());
            platoModel.setRestaurant(platoAntiguo.getRestaurant());

            platoPersistencePort.actualizarPlato(platoModel,idProp);
        }else{
            throw new NoDataFoundException();
        }
//        throw new NoDataFoundException();
//        platoPersistencePort.actualizarPlato(platoModel);
    }

    @Override
    public void actualizarEstadoPlato(PlatoModel platoModel, Long idProp) {
        PlatoModel platoAntiguo=platoPersistencePort.buscarPlatoId(platoModel.getId());
        RestauranteEntity restaurante = restauranteRepository.findByIdRestaurante(platoAntiguo.getRestaurant().getIdRestaurante());
        Long idPropietario = restaurante.getIdPropietario();

        if (platoAntiguo!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)){

            PlatoModel platoModelNew=new PlatoModel();

            platoModel.setId(platoAntiguo.getId());
            platoModel.setNombre(platoAntiguo.getNombre());
            platoModel.setPrecio(platoAntiguo.getPrecio());
            platoModel.setDescripcion(platoAntiguo.getDescripcion());
            platoModel.setUrlImagen(platoAntiguo.getUrlImagen());
            platoModel.setActivo(platoModel.isActivo());
            platoModel.setCategoria(platoAntiguo.getCategoria());
            platoModel.setRestaurant(platoAntiguo.getRestaurant());

            platoPersistencePort.actualizarPlato(platoModel,idProp);
        }else{
            throw new NoDataFoundException();
        }
//        throw new NoDataFoundException();
    }

    @Override
    public List<PlatoModel> listarPlatosPaginados(Long idRest, Integer numeroPaginas, Integer elementoPorPagina) {
        return platoPersistencePort.listarPlatosPaginados(idRest,numeroPaginas, elementoPorPagina);
    }

    @Override
    public PlatoModel buscarPlatoId(Long idPlato) {

        return platoPersistencePort.buscarPlatoId(idPlato);
    }


}
