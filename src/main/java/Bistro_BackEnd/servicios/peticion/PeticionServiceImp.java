package Bistro_BackEnd.servicios.peticion;

import Bistro_BackEnd.controladores.peticion.PeticionBodyPost;
import Bistro_BackEnd.controladores.peticion.PeticionBodyResponse;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.peticion.SolicitudDao;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeticionServiceImp implements PeticionService{

    @Autowired
    private MozoDao mozoDao;

    @Autowired
    private SolicitudDao peticionDao;

    @Override
    public PeticionBodyResponse getById(Integer idValue) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idValue);
        if(!peticionDao.existsById(id)){ throw new ExcepcionIdInvalida(id); }
        else{
            Solicitud petR = peticionDao.findById(id).orElse(new Solicitud());
            return new PeticionBodyResponse(petR);
        }
    }

    @Override
    public void createPeticion(PeticionBodyPost body) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(body.getEmpleadoId());
        if(!mozoDao.existsById(id)){ throw new ExcepcionIdInvalida(id); }
        else{
            Solicitud petNew = new Solicitud(body.getDestino(),body.getOrigen(),body.getAsunto(),body.getBody());
            Mozo mozoR = mozoDao.findById(id).orElse(new Mozo());
            mozoR.addSolicitud(petNew);
            mozoDao.save(mozoR);
        }
    }

    @Override
    public void deletePeticion(Integer idEmpleado, Integer idValue) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idValue);
        Long idEmp = Long.valueOf(idEmpleado);
        if(!peticionDao.existsById(id)){ throw new ExcepcionIdInvalida(id); }
        if(!mozoDao.existsById(idEmp)){ throw new ExcepcionIdInvalida(id); }

        Mozo m = mozoDao.findById(idEmp).orElse(new Mozo());
        List<Solicitud> temp = m.getSolicitudes().stream().filter(p -> !p.getId().equals(id)).collect(Collectors.toList());
        m.setSolicitudes(temp);
        mozoDao.save(m);
    }
}
