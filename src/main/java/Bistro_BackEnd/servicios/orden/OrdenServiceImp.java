package Bistro_BackEnd.servicios.orden;

import Bistro_BackEnd.controladores.orden.OrdenBodyPost;
import Bistro_BackEnd.controladores.orden.OrdenBodyPut;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponse;
import Bistro_BackEnd.dao.consumibles.BebidaDao;
import Bistro_BackEnd.dao.consumibles.PlatoDao;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponseList;
import Bistro_BackEnd.dao.orden.OrdenDao;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenServiceImp implements OrdenService {

    @Autowired
    private OrdenDao ordenDao;

    @Autowired
    private MesaDao mesaDao;

    @Autowired
    private PlatoDao platoDao;

    @Autowired
    private BebidaDao bebidaDao;

    @Autowired
    private MozoDao mozoDao;

    @Override
    public List<OrdenBodyResponseList> list() {
        return ((List<Orden>) ordenDao.findAll()).stream().map(OrdenBodyResponseList::new).collect(Collectors.toList());
    }

    @Override
    public OrdenBodyResponse getById(Integer idParam) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idParam);
        this.validarId(id);
        Orden orden = ordenDao.findById(id).orElse(new Orden());
        return new OrdenBodyResponse(orden);
    }

    @Override
    public Integer save(OrdenBodyPost ordenBody) throws ExcepcionIdInvalida {
        this.validarIdMozo(Long.valueOf(ordenBody.getMozoId()));
        this.validarIdMesa(Long.valueOf(ordenBody.getMesaId()));

        List<Integer> valuesB = ordenBody.getBebidas();
        List<Integer> valuesP = ordenBody.getPlatos();

        List<Bebida> bebidas = valuesB.stream().map(id -> bebidaDao.findById(Long.valueOf(id)).orElse(new Bebida())).collect(Collectors.toList());
        List<Plato> platos = valuesP.stream().map(id -> platoDao.findById(Long.valueOf(id)).orElse(new Plato())).collect(Collectors.toList()); ;
        Orden newOrden = new Orden(bebidas, platos);

        int ordenId = this.ordenDao.save(newOrden).getId().intValue();

        Mesa mesa = this.mesaDao.findById(Long.valueOf(ordenBody.getMesaId())).orElse(new Mesa());

        mesa.setOrden(this.ordenDao.findById((long) ordenId).orElse(new Orden()));
        mesaDao.save(mesa);

        return ordenId;
    }

    @Override
    public void delete(Integer id) throws ExcepcionIdInvalida {
        Long value = Long.valueOf(id);
        this.validarId(value);
        this.ordenDao.deleteById(value);
    }

    @Override
    public void update(OrdenBodyPut ordenBody) throws ExcepcionIdInvalida {
        Long value = Long.valueOf(ordenBody.getOrdenId());
        this.validarIdMozo(Long.valueOf(ordenBody.getMozoId()));

        Orden recOrden = ordenDao.findById(value).orElse(new Orden());

        recOrden.setBebida(ordenBody.getBebidas().stream().map(id -> bebidaDao.findById(Long.valueOf(id)).orElse(new Bebida())).collect(Collectors.toList()));
        recOrden.setPlato(ordenBody.getPlatos().stream().map(id -> platoDao.findById(Long.valueOf(id)).orElse(new Plato())).collect(Collectors.toList()));

        ordenDao.save(recOrden);
    }

    private void validarIdMesa(Long id) throws ExcepcionIdInvalida {
        if (!mesaDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }

    private void validarIdMozo(Long id) throws ExcepcionIdInvalida {
        if (!mozoDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }

    private void validarId(Long id) throws ExcepcionIdInvalida {
        if (!ordenDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }
}
