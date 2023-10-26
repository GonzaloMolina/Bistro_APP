package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.empleado.LogInResponseBody;
import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.controladores.empleado.PeticionBodyResponseList;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;

import java.util.List;

public interface MozoService {

    List<MozoResponseBody> listAll();

    MozoResponseBody getById(Integer id) throws ExcepcionIdInvalida, ExcepcionIdInvalida;

    LogInResponseBody logIn(LogInBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException;

    List<PeticionBodyResponseList> getRequestById(Integer id) throws ExcepcionIdInvalida;
}
