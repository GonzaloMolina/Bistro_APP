package Bistro_BackEnd;

import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.orden.OrdenDao;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.empleado.Mozo;

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
        List<Mesa> mesas1 = new ArrayList<>();
        mesas1.add(mesa); mesas1.add(mesa1);

        Mozo emp = new Mozo("Smitty", "Smith");
        emp.setMesasAsignadas(mesas1);
        empDao.save(emp);
/////////////////////////////////////////////////////////////////////////////

        Mesa mesa2 = new Mesa();Mesa mesa3 = new Mesa();
        List<Mesa> mesas2 = new ArrayList<>();
        mesas2.add(mesa2); mesas2.add(mesa3);

        Mozo emp1 = new Mozo("Fidel", "Martinez");
        emp1.setMesasAsignadas(mesas2);
        empDao.save(emp1);
/////////////////////////////////////////////////////////////////////////////

        Mesa mesa4 = new Mesa();Mesa mesa5 = new Mesa();
        List<Mesa> mesas3 = new ArrayList<>();
        mesas3.add(mesa4); mesas3.add(mesa5);

        Mozo emp2 = new Mozo("Valentin", "Barco");
        emp2.setMesasAsignadas(mesas3);
        empDao.save(emp2);
/////////////////////////////////////////////////////////////////////////////

        Bebida bebida0 = new Bebida("2,25l", TamanioBebida.GRANDE, 800.00);
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(bebida0);
        Plato plato0 = new Plato("", 20000.00, TipoPlato.POSTRE);
        List<Plato> platos = new ArrayList<>();
        platos.add(plato0);

        Orden orden = new Orden(bebidas, platos);
        orderDao.save(orden);
/////////////////////////////////////////////////////////////////////////////
    }
}
