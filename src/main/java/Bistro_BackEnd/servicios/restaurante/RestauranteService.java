package Bistro_BackEnd.servicios.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.restaurante.RestauranteBodyResponse;
import Bistro_BackEnd.controladores.restaurante.RestauranteSimpleBodyResponse;
import Bistro_BackEnd.controladores.restaurante.StateBody;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;

public interface RestauranteService {
    RestauranteBodyResponse logIn(LogInBody body) throws InvalidOrNullFieldException;
    RestauranteSimpleBodyResponse getInfo(LogInBody body) throws InvalidOrNullFieldException;
    void updateState(StateBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException;
}
