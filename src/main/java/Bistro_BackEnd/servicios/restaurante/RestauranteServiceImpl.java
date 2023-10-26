package Bistro_BackEnd.servicios.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.restaurante.RestauranteBodyResponse;
import Bistro_BackEnd.controladores.restaurante.RestauranteSimpleBodyResponse;
import Bistro_BackEnd.dao.restaurante.RestauranteDao;
import Bistro_BackEnd.model.restaurante.Restaurante;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    private RestauranteDao dao;

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
}
