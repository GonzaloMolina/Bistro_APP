package Bistro_BackEnd.servicios.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.restaurante.RestauranteBodyResponse;
import Bistro_BackEnd.controladores.restaurante.RestauranteSimpleBodyResponse;
import Bistro_BackEnd.controladores.restaurante.StateBody;
import Bistro_BackEnd.dao.peticion.SolicitudDao;
import Bistro_BackEnd.dao.restaurante.RestauranteDao;
import Bistro_BackEnd.model.empleado.Estado;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.model.restaurante.Restaurante;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    private RestauranteDao dao;
    @Autowired
    private SolicitudDao solDao;

    @Override
    public RestauranteBodyResponse logIn(LogInBody body) throws InvalidOrNullFieldException {
        String mail = body.getEmail();
        String pass = body.getPassword();

        Restaurante res = dao.findById(mail).orElse(new Restaurante());
        if(new BCryptPasswordEncoder().matches(pass, res.getPassword())){
            return new RestauranteBodyResponse(res);
        }else{
            throw new InvalidOrNullFieldException(mail);
        }
    }

    @Override
    public RestauranteSimpleBodyResponse getInfo(LogInBody body) throws InvalidOrNullFieldException {
        Restaurante res = dao.findById(body.getEmail()).orElse(new Restaurante());
        if(res.getAdminName() == null){ throw new InvalidOrNullFieldException(body.getEmail()); }
        else{ return new RestauranteSimpleBodyResponse(res); }
    }

    @Override
    public void updateState(StateBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException {
        Long tagetId = body.getTargetRequest();
        String newState = body.getEstado();

        Solicitud retrieved = solDao.findById(tagetId).orElse(new Solicitud());
        if(retrieved.getAsuto() == null){ throw new ExcepcionIdInvalida(tagetId); }
        else {
            if(newState.equals("RECHAZADA")){
                retrieved.setEstado(Estado.RECHAZADA);
                solDao.save(retrieved);
            }
            if(newState.equals("ACEPTADA")){
                retrieved.setEstado(Estado.ACEPTADA);
                solDao.save(retrieved);
            }
            if(!newState.equals("ACEPTADA") && !newState.equals("RECHAZADA")){
                throw new InvalidOrNullFieldException(newState);
            }
        }

    }
}
