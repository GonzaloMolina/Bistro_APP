package Bistro_BackEnd.servicios.mesa;

import Bistro_BackEnd.controladores.mesa.MesaBodyResponse;
import Bistro_BackEnd.controladores.mesa.MesaBodyResponseList;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.orden.OrdenDao;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaServiceImp implements MesaService {

    @Autowired
    private MesaDao mesaDao;
    @Autowired
    private OrdenDao ordenDao;

    @Override
    public List<MesaBodyResponseList> listAll() {
        return ((List<Mesa>) mesaDao.findAll()).stream().map(MesaBodyResponseList::new).collect(Collectors.toList());
    }

    @Override
    public MesaBodyResponse getById(Integer idValue) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idValue);
        if(!mesaDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
        Mesa mesaR = mesaDao.findById(id).orElse(new Mesa());
        mesaR.setCuenta(mesaR.getOrden().calcularCuenta());

        return new MesaBodyResponse(mesaR);
    }
}
