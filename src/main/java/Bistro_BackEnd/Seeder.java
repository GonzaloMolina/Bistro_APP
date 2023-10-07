package Bistro_BackEnd;

import Bistro_BackEnd.dao.menu.MenuDao;
import Bistro_BackEnd.dao.peticion.PeticionDao;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.empleado.Peticion;
import Bistro_BackEnd.model.menu.PlatoM;
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
    private PeticionDao petdao;


    public Seeder(MozoDao empDao, MesaDao mesaDao, OrdenDao ordenDao, MenuDao menuDao, PeticionDao petdao) {
        this.empDao = empDao;
        this.mesaDao = mesaDao;
        this.orderDao = ordenDao;
        this.menuDao = menuDao;
        this.petdao = petdao;
    }

    void plant() {
        Menu menu = new Menu();
/////////////////////////////////////////////////////////////////////////////
        Mesa mesa = new Mesa();Mesa mesa1 = new Mesa();
        List<Mesa> mesas1 = new ArrayList<>();
        mesa.setCapacidad(3);
        mesa1.setCapacidad(3);
        mesas1.add(mesa); mesas1.add(mesa1);

        Mozo emp = new Mozo("Smitty", "Smith", "SS@mail.com", "$2a$04$P4C638KeS..J1FzWl8WMLOoMyRsw8JTgJBFerInAsFh0viVGPjaXG");
        emp.setMesasAsignadas(mesas1);
        empDao.save(emp);
/////////////////////////////////////////////////////////////////////////////

        Mesa mesa2 = new Mesa();Mesa mesa3 = new Mesa();
        mesa2.setCapacidad(4);
        mesa3.setCapacidad(4);
        List<Mesa> mesas2 = new ArrayList<>();
        mesas2.add(mesa2); mesas2.add(mesa3);
//TODO MOZO PASSWORD public123 >> link usefull >>https://bcrypt-generator.com/
        Mozo emp1 = new Mozo("Fidel", "Martinez", "admin@mail.com", "$2a$04$P4C638KeS..J1FzWl8WMLOoMyRsw8JTgJBFerInAsFh0viVGPjaXG");
        emp1.setMesasAsignadas(mesas2);

/////////////////////////////////////////////////////////////////////////////

        Mesa mesa4 = new Mesa();
        mesa4.setCapacidad(5);
        Mesa mesa5 = new Mesa();
        mesa5.setCapacidad(5);
        List<Mesa> mesas3 = new ArrayList<>();
        mesas3.add(mesa4); mesas3.add(mesa5);

        Mozo emp2 = new Mozo("Valentin", "Barco", "VBarco@mail.com", "$2a$04$P4C638KeS..J1FzWl8WMLOoMyRsw8JTgJBFerInAsFh0viVGPjaXG");
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

        Acompanamiento pure = new Acompanamiento("Pure de papas");
        Acompanamiento pureB = new Acompanamiento("Pure de batatas");
        Acompanamiento salad = new Acompanamiento("Ensalada de Tomate y lechuga");
        Acompanamiento rise = new Acompanamiento("Arroz");
        Acompanamiento honey = new Acompanamiento("Miel");
        Salsa sauce =new Salsa("Fileto");
        Salsa sauce1 =new Salsa("Pesto genovés");


        PlatoM plato0 = (new PlatoM("Milanesa", 1234.0, TipoPlato.CARNE));
        plato0.addAcompanamiento(pure);
        PlatoM plato1 = new PlatoM("Pechuga de pollo", 1032.0, TipoPlato.CARNE);
        plato1.addAcompanamiento(pureB);
        PlatoM plato2 = new PlatoM("Costilla de cerdo", 4531.0, TipoPlato.CARNE);
        plato2.addAcompanamiento(salad);
        plato2.addAcompanamiento(pure);
        PlatoM plato3 = new PlatoM("Sesos de vaca", 0.0, TipoPlato.CARNE);

        PlatoM plato4 = new PlatoM("Canelones", 10200.0, TipoPlato.PASTA);
        plato4.addSalsa(sauce);
        PlatoM plato5 = new PlatoM("Espagueti", 5230.0, TipoPlato.PASTA);
        plato5.addSalsa(sauce);
        plato5.addSalsa(sauce1);
        PlatoM plato6 = new PlatoM("Fettuccini", 684.0, TipoPlato.PASTA);
        plato6.addSalsa(sauce1);
        PlatoM plato7 = new PlatoM("Ñoquis", 5372.0, TipoPlato.PASTA);

        PlatoM plato8 = new PlatoM("Salmon", 7544.0, TipoPlato.PESCADO);
        plato8.addAcompanamiento(rise);
        PlatoM plato9 = new PlatoM("Atun", 5682.0, TipoPlato.PESCADO);
        plato9.addAcompanamiento(rise);
        PlatoM platoA = new PlatoM("Trucha", 7950.0, TipoPlato.PESCADO);
        platoA.addAcompanamiento(rise);
        PlatoM platoB = new PlatoM("Pejerey", 8954.0, TipoPlato.PESCADO);
        platoB.addAcompanamiento(rise);

        PlatoM platoC = new PlatoM("Tiramisu", 345430.0, TipoPlato.POSTRE);
        PlatoM platoD = new PlatoM("Budin de chocolate", 3242.0, TipoPlato.POSTRE);
        platoD.addAcompanamiento(honey);
        PlatoM platoE = new PlatoM("Sufle", 2312.0, TipoPlato.POSTRE);
        PlatoM platoF = new PlatoM("3 Bochas de helado", 3543.0, TipoPlato.POSTRE);

        List<PlatoM> platosMenu = new ArrayList<>();
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
        Bebida bebida11 = new Bebida("Red Bull", TamanioBebida.CHICO, 700.00);
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
        mesa3.setOrden(orden);
        empDao.save(emp1);
        //orderDao.save(orden);
/////////////////////////////////////////////////////////////////////////////
    }
}
