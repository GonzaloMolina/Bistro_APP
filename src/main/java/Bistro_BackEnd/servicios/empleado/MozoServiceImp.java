package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.empleado.Mozo;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MozoServiceImp implements MozoService{

    @Autowired
    private MozoDao mozoDao;

    public List<MozoResponseBody> listAll() {
        return ((List<Mozo>) mozoDao.findAll()).stream().map(MozoResponseBody::new).collect(Collectors.toList());
    }

    @Override
    public MozoResponseBody getById(Integer idParam) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idParam);
        this.validarId(id);
        Mozo mozo = mozoDao.findById(id).orElse(new Mozo());
        return new MozoResponseBody(mozo);
    }

    private void validarId(Long id) throws ExcepcionIdInvalida {
        if (!mozoDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }
}
