package Bistro_BackEnd.servicios.menu;

import Bistro_BackEnd.controladores.menu.MenuResponseBody;
import Bistro_BackEnd.dao.menu.MenuDao;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuResponseBody getById(Integer idValue) throws ExcepcionIdInvalida {
        Long id = Long.valueOf(idValue);
        if(!menuDao.existsById(id)){
            throw new ExcepcionIdInvalida(id);
        }
        return new MenuResponseBody(menuDao.findById(id).orElse(new Menu()));
    }
}
