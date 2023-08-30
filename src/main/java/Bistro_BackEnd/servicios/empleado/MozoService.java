package Bistro_BackEnd.servicios.empleado;

import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.empleado.Mozo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MozoService {
    @Autowired
    private MozoDao mozoDao;

    public List<Mozo> list() {
        return (List<Mozo>) mozoDao.findAll();
    }
}
