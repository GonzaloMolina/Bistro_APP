package Bistro_BackEnd.servicios.mesa;

import Bistro_BackEnd.controladores.mesa.MesaBodyResponse;
import Bistro_BackEnd.controladores.mesa.MesaBodyResponseList;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;

import java.util.List;

public interface MesaService {

    List<MesaBodyResponseList> listAll();
    MesaBodyResponse getById(Integer id) throws ExcepcionIdInvalida;
    MesaBodyResponse releaseTable(Integer id) throws ExcepcionIdInvalida;
}
