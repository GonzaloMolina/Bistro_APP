package Bistro_BackEnd.servicios.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.restaurante.*;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.menu.MenuDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.peticion.SolicitudDao;
import Bistro_BackEnd.dao.restaurante.RestauranteDao;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.empleado.Estado;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.menu.PlatoM;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.restaurante.Restaurante;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    private RestauranteDao dao;
    @Autowired
    private SolicitudDao solDao;
    @Autowired
    private MozoDao mozoDao;
    @Autowired
    private MesaDao mesaDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public RestauranteBodyResponse logIn(LogInBody body) throws InvalidOrNullFieldException {
        String mail = body.getEmail();
        String pass = body.getPassword();

        Restaurante res = dao.findById(mail).orElse(new Restaurante());
        System.out.println(new BCryptPasswordEncoder().matches(pass, res.getPassword()));
        if(new BCryptPasswordEncoder().matches(pass, res.getPassword())){
            return new RestauranteBodyResponse(res);
        }else{
            throw new InvalidOrNullFieldException(mail);
        }
    }

    @Override
    public RestauranteBodyResponse getInfo(LogInBody body) throws InvalidOrNullFieldException {
        Restaurante res = dao.findById(body.getEmail()).orElse(new Restaurante());
        if(res.getAdminName() == null){ throw new InvalidOrNullFieldException(body.getEmail()); }
        else{ return new RestauranteBodyResponse(res); }
    }

    @Override
    public RestauranteBodyResponse updateState(StateBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException {
        Long tagetId = body.getTargetRequest();
        String newState = body.getEstado();
        String email = body.getAdminEmail();

        Solicitud retrieved = solDao.findById(tagetId).orElse(new Solicitud());
        if(!(newState.equals("ACEPTADA") || newState.equals("RECHAZADA"))){
            throw new InvalidOrNullFieldException(newState);
        }
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
            return new RestauranteBodyResponse(dao.findById(email).orElse(new Restaurante()));
        }
    }

    @Override
    public RestauranteBodyResponse createEmployee(MozoBody body) throws InvalidOrNullFieldException {
        boolean exist = ((List<Mozo>) mozoDao.findAll()).stream()
                .anyMatch(mozo -> mozo.getEmail().equals(body.getMail()));
        if(exist){ throw new InvalidOrNullFieldException("Employee exist"); }
        if(!dao.existsById(body.getRestoEmail())){ throw new InvalidOrNullFieldException("Resto email"); }
        Restaurante resto = dao.findById(body.getRestoEmail()).orElse(new Restaurante());

        String pass = new BCryptPasswordEncoder().encode(body.getPassword());
        Mozo newMozo = new Mozo(body.getNombre(), body.getApellido(), body.getMail(), pass, resto);

        resto.addEmpleado(newMozo);
        dao.save(resto);

        return new RestauranteBodyResponse(resto);
    }

    @Override
    public RestauranteBodyResponse deleteEmployee(DeleteBody body) throws InvalidOrNullFieldException, ExcepcionIdInvalida {
        Long target = Long.valueOf(body.getTarget());
        String email = body.getAdmin();
        if(email == null){ throw new InvalidOrNullFieldException("email"); }
        if(!dao.existsById(email)){throw new InvalidOrNullFieldException("email"); }
        if(!mozoDao.existsById(target)){throw new ExcepcionIdInvalida(target);}
        Restaurante retrieved = dao.findById(email).orElse(new Restaurante());
        Mozo mock = new Mozo();
        mock.setId(target);

        retrieved.deleteEmpleado(mock);
        dao.save(retrieved);
        mozoDao.deleteById(target);

        return new RestauranteBodyResponse(retrieved);
    }

    @Override
    public RestauranteBodyResponse createTable(MesaBody body) throws InvalidOrNullFieldException {
        if(!dao.existsById(body.getAdminEmail())){ throw new InvalidOrNullFieldException("Resto email"); }
        Restaurante resto = dao.findById(body.getAdminEmail()).orElse(new Restaurante());
        Mesa newMesa = new Mesa(resto.getMenu().getId());
        newMesa.setCapacidad(body.getCapacidad());
        newMesa.setCuenta(0.0);

        resto.addMesa(newMesa);
        dao.save(resto);
        return new RestauranteBodyResponse(resto);
    }

    @Override
    public RestauranteBodyResponse deleteTable(DeleteBody body) throws InvalidOrNullFieldException, ExcepcionIdInvalida {
        if(!dao.existsById(body.getAdmin())){ throw new InvalidOrNullFieldException("Resto email"); }
        if(!mesaDao.existsById(Long.valueOf(body.getTarget()))){ throw new ExcepcionIdInvalida(Long.valueOf(body.getTarget())); }
        Restaurante rest = dao.findById(body.getAdmin()).orElse(new Restaurante());
        Mesa mesa = mesaDao.findById(Long.valueOf(body.getTarget())).orElse(new Mesa());

        rest.deleteMesa(mesa);
        dao.save(rest);
        mesaDao.deleteById(mesa.getId());

        return new RestauranteBodyResponse(rest);
    }

    @Override
    public void register(RestauranteBody body) throws InvalidOrNullFieldException {
        if(dao.existsById(body.getEmail())){ throw new InvalidOrNullFieldException("Resto email"); }
        else { System.out.println(body.getPassword());
            String pass = new BCryptPasswordEncoder().encode(body.getPassword());
            body.setPassword(pass);
            System.out.println(body.getPassword());
            Restaurante newResto = new Restaurante(body);
            Menu menu = menuDao.save(newResto.getMenu());
            newResto.setMenu(menu);
            dao.save(newResto);
        }
    }

    @Override
    public RestauranteBodyResponse asignarMesa(AsignarBody body) throws InvalidOrNullFieldException {
        if(!dao.existsById(body.getAdmin())){ throw new InvalidOrNullFieldException("ADMIN"); }
        if(!mozoDao.existsById(Long.valueOf(body.getEmpleadoId()))){ throw new InvalidOrNullFieldException("emp ID"); }
        if(!mesaDao.existsById(Long.valueOf(body.getMesaId()))){ throw new InvalidOrNullFieldException("mesa ID"); }

        Mozo emp = mozoDao.findById(Long.valueOf(body.getEmpleadoId())).orElse(new Mozo());
        Mesa t = mesaDao.findById(Long.valueOf(body.getMesaId())).orElse(new Mesa());
        t.cambiarEstado();
        emp.addMesa(t);
        mesaDao.save(t);
        mozoDao.save(emp);
        return new RestauranteBodyResponse(dao.findById(body.getAdmin()).orElse(new Restaurante()));
    }

    @Override
    public RestauranteBodyResponse desasignarMesa(AsignarBody body) throws InvalidOrNullFieldException {
        if(!dao.existsById(body.getAdmin())){ throw new InvalidOrNullFieldException("ADMIN"); }
        if(!mozoDao.existsById(Long.valueOf(body.getEmpleadoId()))){ throw new InvalidOrNullFieldException("emp ID"); }
        if(!mesaDao.existsById(Long.valueOf(body.getMesaId()))){ throw new InvalidOrNullFieldException("mesa ID"); }

        Mozo emp = mozoDao.findById(Long.valueOf(body.getEmpleadoId())).orElse(new Mozo());
        Mesa t = mesaDao.findById(Long.valueOf(body.getMesaId())).orElse(new Mesa());
        t.cambiarEstado();
        emp.removeMesa(t);
        mesaDao.save(t);
        mozoDao.save(emp);
        return new RestauranteBodyResponse(dao.findById(body.getAdmin()).orElse(new Restaurante()));
    }

    @Override
    public Restaurante crearPlato(PlatoBody body) throws InvalidOrNullFieldException {
        if(!dao.existsById(body.getAdmin())){ throw new InvalidOrNullFieldException("ADMIN"); }
        else{
            Restaurante res = dao.findById(body.getAdmin()).orElse(new Restaurante());
            TipoPlato type = this.mapType(body.getTipo().toLowerCase());
            PlatoM ptl = new PlatoM(body.getNombre(), body.getPrecio(), body.getCost(), type);

            res.getMenu().addPlate(ptl);
            dao.save(res);
            return res;
        }
    }

    private TipoPlato mapType(String tipo){
        switch (tipo) {
            case("pasta"): return TipoPlato.PASTA;
            case("pescado"): return TipoPlato.PESCADO;
            case("postre"): return TipoPlato.POSTRE;
            default: return TipoPlato.CARNE;
        }
    }

    @Override
    public Restaurante deleteConsumible(DeleteBody body) throws InvalidOrNullFieldException {
        if(!dao.existsById(body.getAdmin())){ throw new InvalidOrNullFieldException("ADMIN"); }
        else{
            Restaurante res = dao.findById(body.getAdmin()).orElse(new Restaurante());
            res.getMenu().deletePlato(Long.valueOf(body.getTarget()));
            res.getMenu().deleteBebida(Long.valueOf(body.getTarget()));
            dao.save(res);
            return res;
        }
    }
}
