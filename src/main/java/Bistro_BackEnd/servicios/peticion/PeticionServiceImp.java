package Bistro_BackEnd.servicios.peticion;

import Bistro_BackEnd.controladores.peticion.PeticionBodyPost;
import Bistro_BackEnd.controladores.peticion.PeticionBodyResponse;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.peticion.PeticionDao;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Peticion;
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
    private PeticionDao peticionDao;

    @Override
    public PeticionBodyResponse getById(Integer idValue) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idValue);
        if(!peticionDao.existsById(id)){ throw new ExcepcionIdInvalida(id); }
        else{
            Peticion petR = peticionDao.findById(id).orElse(new Peticion());
            return new PeticionBodyResponse(petR);
        }
    }

    @Override
    public void createPeticion(PeticionBodyPost body) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(body.getEmpleadoId());
        if(!mozoDao.existsById(id)){ throw new ExcepcionIdInvalida(id); }
        else{
            Peticion petNew = new Peticion(body.getDestino(),body.getOrigen(),body.getAsunto(),body.getBody());
            Mozo mozoR = mozoDao.findById(id).orElse(new Mozo());
            mozoR.addPeticion(petNew);
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
        List<Peticion> temp = m.getPeticiones().stream().filter(p -> !p.getId().equals(id)).collect(Collectors.toList());
        m.setPeticiones(temp);
        mozoDao.save(m);
    }
}
