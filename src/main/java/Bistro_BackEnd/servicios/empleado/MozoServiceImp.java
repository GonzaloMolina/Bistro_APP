package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
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
    public MozoResponseBody logIn(LogInBody body) throws ExcepcionIdInvalida {
        List<Mozo> mozoR = ((List<Mozo>) mozoDao.findAll()).stream().filter(
                mozo -> {
                    return mozo.getEmail().equals(body.getEmail()) &&
                            new BCryptPasswordEncoder().matches(body.getPassword(), mozo.getPassword());
                }
        ).collect(Collectors.toList());
        if(mozoR.size()==1){
            return new MozoResponseBody(mozoR.get(0));
        }else{
            throw new ExcepcionIdInvalida(0L);
        }
    }

    private void validarId(Long id) throws ExcepcionIdInvalida {
        if (!mozoDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
    }
}
