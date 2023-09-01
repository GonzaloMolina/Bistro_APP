package Bistro_BackEnd.servicios.orden;

import Bistro_BackEnd.controladores.orden.OrdenBodyResponse;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponseList;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;

import java.util.List;

public interface OrdenService {
    List<OrdenBodyResponseList> list();
    OrdenBodyResponse getById(Integer id) throws ExcepcionIdInvalida;
}
