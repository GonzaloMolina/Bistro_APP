package Bistro_BackEnd;

import Bistro_BackEnd.Mesa.Mesa;
import Bistro_BackEnd.Orden.Orden;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.orden.OrdenDao;
import Bistro_BackEnd.empleado.Mozo;

import java.util.ArrayList;
import java.util.List;

public class Seeder {

    private OrdenDao orderDao;
    private MozoDao empDao;
    private MesaDao mesaDao;

    public Seeder(MozoDao empDao, MesaDao mesaDao, OrdenDao ordenDao) {
        this.empDao = empDao;
        this.mesaDao = mesaDao;
        this.orderDao = ordenDao;
    }

    void plant() {
        Mesa mesa = new Mesa();Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa();Mesa mesa5 = new Mesa();

        List<Mesa> mesas1 = new ArrayList<>();
        mesas1.add(mesa); mesas1.add(mesa1);

        List<Mesa> mesas2 = new ArrayList<>();
        mesas1.add(mesa2); mesas1.add(mesa3);

        List<Mesa> mesas3 = new ArrayList<>();
        mesas1.add(mesa4); mesas1.add(mesa5);


        Mozo emp = new Mozo("Smitty", "Smith");
        empDao.save(emp);

        Mozo emp1 = new Mozo("Dummy", "Dummer");
        emp.setMesasAsignadas(mesas1);
        empDao.save(emp1);

        Mozo emp2 = new Mozo("Jason", "Johnson");
        emp.setMesasAsignadas(mesas2);
        empDao.save(emp2);

        Mozo emp3 = new Mozo("Valentin", "Barco");
        emp.setMesasAsignadas(mesas3);
        empDao.save(emp3);

        Orden order = new Orden();
        orderDao.save(order);

        Orden order1 = new Orden();
        orderDao.save(order1);

        Orden order2 = new Orden();
        orderDao.save(order2);

        Orden order3 = new Orden();
        orderDao.save(order3);

        Orden order4 = new Orden();
        orderDao.save(order4);
    }
}
