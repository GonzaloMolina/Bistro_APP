package Bistro_BackEnd.servicios.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.controladores.restaurante.*;
import Bistro_BackEnd.model.restaurante.Restaurante;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;

public interface RestauranteService {
    RestauranteBodyResponse logIn(LogInBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse getInfo(LogInBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse updateState(StateBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException;
    RestauranteBodyResponse createEmployee(MozoBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse deleteEmployee(DeleteBody body) throws InvalidOrNullFieldException, ExcepcionIdInvalida;
    RestauranteBodyResponse createTable(MesaBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse deleteTable(DeleteBody body) throws InvalidOrNullFieldException, ExcepcionIdInvalida;
    void register(RestauranteBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse asignarMesa(AsignarBody body) throws InvalidOrNullFieldException;
    RestauranteBodyResponse desasignarMesa(AsignarBody body) throws InvalidOrNullFieldException;
    Restaurante crearPlato(PlatoBody body) throws InvalidOrNullFieldException;
    Restaurante deleteConsumible(DeleteBody body) throws InvalidOrNullFieldException;
}
