package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;

import java.util.List;

public interface MozoService {

    List<MozoResponseBody> listAll();

    MozoResponseBody getById(Integer id) throws ExcepcionIdInvalida, ExcepcionIdInvalida;

    MozoResponseBody logIn(LogInBody body) throws ExcepcionIdInvalida;
}
