package Bistro_BackEnd;

import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.empleado.Mozo;

public class Seeder {

    private final MozoDao empDao;

    public Seeder(MozoDao empDao) {
        this.empDao = empDao;
    }

    public void plant() {
        Mozo emp = new Mozo("Smitty", "Smith");
        empDao.save(emp);
    }
}
