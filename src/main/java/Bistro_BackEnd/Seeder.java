package Bistro_BackEnd;

import Bistro_BackEnd.dao.menu.MenuDao;
import Bistro_BackEnd.model.Menu.Menu;
import Bistro_BackEnd.model.empleado.Peticion;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.dao.mesa.MesaDao;
import Bistro_BackEnd.dao.orden.OrdenDao;
import Bistro_BackEnd.model.consumibles.Acompanamiento;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.consumibles.Salsa;
import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.empleado.Mozo;

import java.util.ArrayList;
import java.util.List;

public class Seeder {

    private OrdenDao orderDao;
    private MozoDao empDao;
    private MesaDao mesaDao;
    private MenuDao menuDao;


    public Seeder(MozoDao empDao, MesaDao mesaDao, OrdenDao ordenDao, MenuDao menuDao) {
        this.empDao = empDao;
        this.mesaDao = mesaDao;
        this.orderDao = ordenDao;
        this.menuDao = menuDao;
    }

    void plant() {
        Menu menu = new Menu();
/////////////////////////////////////////////////////////////////////////////
        Mesa mesa = new Mesa();Mesa mesa1 = new Mesa();
        List<Mesa> mesas1 = new ArrayList<>();
        mesa.setCapacidad(3);
        mesa1.setCapacidad(3);
        mesas1.add(mesa); mesas1.add(mesa1);

        Mozo emp = new Mozo("Smitty", "Smith", "admin@mail.com", "public123");
        emp.setMesasAsignadas(mesas1);
        empDao.save(emp);
/////////////////////////////////////////////////////////////////////////////

        Mesa mesa2 = new Mesa();Mesa mesa3 = new Mesa();
        mesa2.setCapacidad(4);
        mesa3.setCapacidad(4);
        List<Mesa> mesas2 = new ArrayList<>();
        mesas2.add(mesa2); mesas2.add(mesa3);

        Mozo emp1 = new Mozo("Fidel", "Martinez", "admin@mail.com", "public123");
        emp1.setMesasAsignadas(mesas2);
        emp1.addPeticion(new Peticion("sistem@mail.com", "admin@mail.com", "Licencia por enfermedad", ""));
        empDao.save(emp1);
/////////////////////////////////////////////////////////////////////////////

        Mesa mesa4 = new Mesa();
        mesa4.setCapacidad(5);
        Mesa mesa5 = new Mesa();
        mesa5.setCapacidad(5);
        List<Mesa> mesas3 = new ArrayList<>();
        mesas3.add(mesa4); mesas3.add(mesa5);

        Mozo emp2 = new Mozo("Valentin", "Barco", "admin@mail.com", "public123");
        emp2.setMesasAsignadas(mesas3);
        empDao.save(emp2);
/////////////////////////////////////////////////////////////////////////////
        //bob esponja
        Bebida bebida0 = new Bebida("Coca-Cola 3l", TamanioBebida.GRANDE, 800.00);
        Bebida bebida1 = new Bebida("Coca-Cola 1,5l", TamanioBebida.MEDIANO, 700.00);
        Bebida bebida2 = new Bebida("Coca-Cola 500ml", TamanioBebida.CHICO, 600.00);

        Bebida bebida3 = new Bebida("Fanta 500ml", TamanioBebida.CHICO, 600.00);
        Bebida bebida4 = new Bebida("Fanta 1,5l", TamanioBebida.MEDIANO, 700.00);
        Bebida bebida5 = new Bebida("Fanta 3l", TamanioBebida.GRANDE, 800.00);

        Bebida bebida6 = new Bebida("Sprite 500ml", TamanioBebida.CHICO, 600.00);
        Bebida bebida7 = new Bebida("Sprite 1,5l", TamanioBebida.MEDIANO, 700.00);
        Bebida bebida8 = new Bebida("Sprite 3l", TamanioBebida.GRANDE, 800.00);

        Bebida bebida9 = new Bebida("Pepsi 500ml", TamanioBebida.CHICO, 600.00);
        Bebida bebidaA = new Bebida("Pepsi 1,5l", TamanioBebida.MEDIANO, 700.00);
        Bebida bebidaB = new Bebida("Pepsi 3l", TamanioBebida.GRANDE, 800.00);

        Bebida bebidaC = new Bebida("7up 500ml", TamanioBebida.CHICO, 600.00);
        Bebida bebidaD = new Bebida("7up 1,5l", TamanioBebida.MEDIANO, 700.00);
        Bebida bebidaE = new Bebida("7up 3l", TamanioBebida.GRANDE, 800.00);

        List<Bebida> bebidasMenu = new ArrayList<>();
        bebidasMenu.add(bebida0);
        bebidasMenu.add(bebida1);
        bebidasMenu.add(bebida2);
        bebidasMenu.add(bebida3);
        bebidasMenu.add(bebida4);
        bebidasMenu.add(bebida5);
        bebidasMenu.add(bebida6);
        bebidasMenu.add(bebida7);
        bebidasMenu.add(bebida8);
        bebidasMenu.add(bebida9);
        bebidasMenu.add(bebidaA);
        bebidasMenu.add(bebidaB);
        bebidasMenu.add(bebidaC);
        bebidasMenu.add(bebidaD);
        bebidasMenu.add(bebidaE);

        Plato plato0 = new Plato("Milanesa", 1234.0, TipoPlato.CARNE);
        Plato plato1 = new Plato("pechuga de pollo", 1032.0, TipoPlato.CARNE);
        Plato plato2 = new Plato("costilla de cerdo", 4531.0, TipoPlato.CARNE);
        Plato plato3 = new Plato("cesos de vaca", 0.0, TipoPlato.CARNE);

        Plato plato4 = new Plato("Canelones", 10200.0, TipoPlato.PASTA);
        Plato plato5 = new Plato("Espagueti", 5230.0, TipoPlato.PASTA);
        Plato plato6 = new Plato("Fettuccini", 684.0, TipoPlato.PASTA);
        Plato plato7 = new Plato("Ñoquis", 5372.0, TipoPlato.PASTA);

        Plato plato8 = new Plato("Salmon", 7544.0, TipoPlato.PESCADO);
        Plato plato9 = new Plato("Atun", 5682.0, TipoPlato.PESCADO);
        Plato platoA = new Plato("Trucha", 7950.0, TipoPlato.PESCADO);
        Plato platoB = new Plato("Pejerey", 8954.0, TipoPlato.PESCADO);

        Plato platoC = new Plato("Tiramisu", 345430.0, TipoPlato.POSTRE);
        Plato platoD = new Plato("Budin de chocolate", 3242.0, TipoPlato.POSTRE);
        Plato platoE = new Plato("Sufle", 2312.0, TipoPlato.POSTRE);
        Plato platoF = new Plato("3bochas de helado", 3543.0, TipoPlato.POSTRE);

        List<Plato> platosMenu = new ArrayList<>();
        platosMenu.add(plato0);
        platosMenu.add(plato1);
        platosMenu.add(plato2);
        platosMenu.add(plato3);
        platosMenu.add(plato4);
        platosMenu.add(plato5);
        platosMenu.add(plato6);
        platosMenu.add(plato7);
        platosMenu.add(plato8);
        platosMenu.add(plato9);
        platosMenu.add(platoA);
        platosMenu.add(platoB);
        platosMenu.add(platoC);
        platosMenu.add(platoD);
        platosMenu.add(platoE);
        platosMenu.add(platoF);

        menu.setBebidas(bebidasMenu);
        menu.setPlatos(platosMenu);
        this.menuDao.save(menu);

/////////////////////////////////////////////////////////////////////////////
        Bebida bebida10 = new Bebida("Quilmes", TamanioBebida.GRANDE, 800.00);
        Bebida bebida11 = new Bebida("red bull", TamanioBebida.CHICO, 700.00);
        List<Bebida> bebidas2 = new ArrayList<>();
        bebidas2.add(bebida10);
        bebidas2.add(bebida11);

        Plato plato = new Plato("Porcion Vacio", 4000.00, TipoPlato.CARNE);
        plato.setAcompanamiento(new Acompanamiento("Papas Fritas"));

        Plato platox = new Plato("Tallarines", 3000.00, TipoPlato.PASTA);
        platox.setSalsa(new Salsa("Bolognesa"));
        List<Plato> platos2 = new ArrayList<>();
        platos2.add(plato);
        platos2.add(platox);

        Orden orden = new Orden(bebidas2, platos2);
        orderDao.save(orden);
/////////////////////////////////////////////////////////////////////////////
    }
}
