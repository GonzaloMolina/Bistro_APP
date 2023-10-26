package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.empleado.LogInResponseBody;
import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.controladores.empleado.PeticionBodyResponseList;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public LogInResponseBody logIn(LogInBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException {
        Mozo mozoR = mozoDao.getUserByUsername(body.getEmail());
        if(mozoR != null){
            if(new BCryptPasswordEncoder().matches(body.getPassword(), mozoR.getPassword())){
                return new LogInResponseBody(mozoR);
            } else{
                System.out.println(mozoR.getPassword());
                System.out.println(body.getPassword());
                throw new InvalidOrNullFieldException(body.getEmail());
            }
        }else{
            throw new ExcepcionIdInvalida(0L);
        }
    }

    @Override
    public List<PeticionBodyResponseList> getRequestById(Integer idP) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idP);
        this.validarId(id);
        Mozo mozo = mozoDao.findById(id).orElse(new Mozo());
        return mozo.getSolicitudes().stream().map(PeticionBodyResponseList::new).collect(Collectors.toList());
    }

    private void validarId(Long id) throws ExcepcionIdInvalida {
        if (!mozoDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }
}
