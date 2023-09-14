package Bistro_BackEnd.servicios.menu;

import Bistro_BackEnd.controladores.menu.MenuResponseBody;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;

public interface MenuService {

    MenuResponseBody getById(Integer id) throws ExcepcionIdInvalida;
}
