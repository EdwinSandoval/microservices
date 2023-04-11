package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;

import java.util.List;

public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;
    private final ICategoriaPersistencePort categoriaPersistencePort;
    private final IRestaurantePersistencePort restaurantePersistencePort;


    private final IPlatoEntityMapper platoEntityMapper;
    private final ICategoriaEntityMapper categoriaEntityMapper;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final IUserFeign iUserFeign;

    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort, ICategoriaPersistencePort categoriaPersistencePort,
                        IRestaurantePersistencePort restaurantePersistencePort, IPlatoEntityMapper platoEntityMapper,
                        ICategoriaEntityMapper categoriaEntityMapper, IRestauranteEntityMapper restauranteEntityMapper,
                        IUserFeign iUserFeign) {
        this.platoPersistencePort = platoPersistencePort;
        this.categoriaPersistencePort = categoriaPersistencePort;
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.platoEntityMapper = platoEntityMapper;
        this.categoriaEntityMapper = categoriaEntityMapper;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.iUserFeign = iUserFeign;
    }

    @Override
    public PlatoModel guardarPlato(Long idProp,PlatoModel platoModel) {
        platoModel.setActivo(true);
        PlatoModel platoModel1=platoModel;
        CategoriaModel categoria=obtenerCategoria(platoModel);
        RestauranteModel restaurante = obtenerRestaurante(platoModel);

        Long idPropietario = restaurante.getIdPropietario();

        if (categoria.getIdCategoria()!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)) {
            platoModel1.setCategoria(categoria);
            platoModel1.setRestaurant(restaurante);
            return platoPersistencePort.guardarPlato(platoModel1);

        }
        throw new NoDataFoundException();
    }

    private CategoriaModel obtenerCategoria(PlatoModel platoModel){
        CategoriaModel categoria=categoriaPersistencePort.obtenerCategoriaId(platoModel.getCategoria().getIdCategoria());
        return categoria;
    }  private RestauranteModel obtenerRestaurante(PlatoModel platoModel){
        RestauranteModel restaurante=restaurantePersistencePort.obtenerRestauranteId(platoModel.getRestaurant().getIdRestaurante());
        return restaurante;
    }

    @Override
    public List<PlatoModel> listarPlatos() {

        return platoPersistencePort.listarPlatos();
    }

    @Override
    public void actualizarPlato(PlatoModel platoModel, Long idProp) {
        PlatoModel plato=buscarPlato(platoModel);
        RestauranteModel restaurante = obtenerRestaurante(plato);

        Long idPropietario = restaurante.getIdPropietario();

        if (plato.getId()!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)){

            PlatoModel platoModelNew=new PlatoModel();

            platoModelNew.setId(plato.getId());
            platoModelNew.setNombre(plato.getNombre());
            platoModelNew.setPrecio(platoModel.getPrecio());
            platoModelNew.setDescripcion(platoModel.getDescripcion());
            platoModelNew.setUrlImagen(plato.getUrlImagen());
            platoModelNew.setActivo(plato.isActivo());
            platoModelNew.setCategoria(plato.getCategoria());
            platoModelNew.setRestaurant(plato.getRestaurant());

            platoPersistencePort.actualizarPlato(platoModelNew,idProp);
        }else{
            throw new NoDataFoundException();
        }

    }

    private PlatoModel buscarPlato(PlatoModel platoModel){
        PlatoModel platoAntiguo=platoPersistencePort.buscarPlatoId(platoModel.getId());
        return platoAntiguo;
    }

    @Override
    public void actualizarEstadoPlato(PlatoModel platoModel, Long idProp) {
        PlatoModel plato=buscarPlato(platoModel);
        RestauranteModel restaurante = obtenerRestaurante(platoModel);
        Long idPropietario = restaurante.getIdPropietario();

        if (plato.getId()!=null && restaurante.getIdRestaurante()!=null && idPropietario.equals(idProp)){

            PlatoModel platoModelNew=new PlatoModel();

            platoModelNew.setId(plato.getId());
            platoModelNew.setNombre(plato.getNombre());
            platoModelNew.setPrecio(plato.getPrecio());
            platoModelNew.setDescripcion(plato.getDescripcion());
            platoModelNew.setUrlImagen(plato.getUrlImagen());
            platoModelNew.setActivo(platoModel.isActivo());
            platoModelNew.setCategoria(plato.getCategoria());
            platoModelNew.setRestaurant(plato.getRestaurant());

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
