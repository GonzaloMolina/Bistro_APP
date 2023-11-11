package Bistro_BackEnd;

import Bistro_BackEnd.dao.menu.MenuDao;
import Bistro_BackEnd.dao.peticion.SolicitudDao;
import Bistro_BackEnd.dao.restaurante.RestauranteDao;
import Bistro_BackEnd.model.empleado.Estado;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.empleado.Solicitud;
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
import Bistro_BackEnd.model.restaurante.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Seeder {

    private RestauranteDao restDao;
    private OrdenDao orderDao;
    private MozoDao empDao;
    private MesaDao mesaDao;
    private MenuDao menuDao;
    private SolicitudDao petdao;

    public Seeder(MozoDao empDao, MesaDao mesaDao, OrdenDao ordenDao, MenuDao menuDao, SolicitudDao petdao, RestauranteDao restDao) {
        this.empDao = empDao;
        this.mesaDao = mesaDao;
        this.orderDao = ordenDao;
        this.menuDao = menuDao;
        this.petdao = petdao;
        this.restDao = restDao;
    }

    void plant() {
        String pass = "$2a$04$P4C638KeS..J1FzWl8WMLOoMyRsw8JTgJBFerInAsFh0viVGPjaXG";

        //password public123
        Restaurante resto = new Restaurante("Axel LG", "Il mondo",
                "axel.lopez.garabal@gmail.com",
                pass, "Nro. tel", "Dir");

        if(!restDao.existsById(resto.getEmail())){
            /////////////////////////////////////////////////
            //TODO MOZO PASSWORD public123 >> link usefull >>https://bcrypt-generator.com/
            Mozo emp = new Mozo("Smitty", "Smith", "SS@mail.com", pass, resto);
            Mozo emp1 = new Mozo("Fidel", "Martinez", "admin@mail.com", pass, resto);
            Mozo emp2 = new Mozo("Valentin", "Barco", "VBarco@mail.com", pass, resto);

            Menu menu = menuDao.save(this.setUpMenu(new Menu()));

            emp.setMesasAsignadas(this.crearMesas(2, menu));

            emp1.setMesasAsignadas(this.crearMesas(4, menu));
            emp1.setSolicitudes(this.generarSolicitudes());
            emp1.getMesasAsignadas().get(1).setOrden(this.generarOrden());

            resto.addOrden(emp1.getMesasAsignadas().get(1).getOrden());
            emp2.setMesasAsignadas(this.crearMesas(2, menu));
            ////////////////////////////////////////////////
            resto.addEmpleado(emp);
            resto.addEmpleado(emp1);
            resto.addEmpleado(emp2);
            ////////////////////////////////////////////////
            resto.setMenu(menu);
            ////////////////////////////////////////////////
            this.addMesasToResto(resto, emp.getMesasAsignadas());
            this.addMesasToResto(resto, emp1.getMesasAsignadas());
            this.addMesasToResto(resto, emp2.getMesasAsignadas());
            ////////////////////////////////////////////////
            restDao.save(resto);
        }
    }

    private void addMesasToResto(Restaurante resto, List<Mesa> mesas){
        List<Mesa> temp = resto.getMesas();
        temp.addAll(mesas);
        resto.setMesas((ArrayList<Mesa>) temp);
    }

    private List<Solicitud> generarSolicitudes() {
        List<Solicitud> res = new ArrayList<>();
        String as = "Cambio de horario";
        String cuerpo = "Un cuerpo que explique lo que pide";

        Solicitud pet1 = new Solicitud("", "admin@mail.com", as, cuerpo);
        pet1.setEstado(Estado.ACEPTADA);
        Solicitud pet2 = new Solicitud("", "admin@mail.com", "Ausencia por enfermedad", cuerpo);
        pet2.setEstado(Estado.ACEPTADA);
        Solicitud pet3 = new Solicitud("jefe@email.com", "admin@mail.com", "Boca vs Palmeiras", cuerpo);
        pet3.setEstado(Estado.RECHAZADA);

        res.add(pet3);
        res.add(pet2);
        res.add(pet1);
        return res;
    }

    private Menu setUpMenu(Menu menu){
        /////////////////////////////////////////////////////////////////////////////

        Bebida bebida0 = new Bebida("Coca-Cola 3l", TamanioBebida.GRANDE, 1200.00, 800.00);
        Bebida bebida1 = new Bebida("Coca-Cola 1,5l", TamanioBebida.MEDIANO, 700.00, 300.00);
        Bebida bebida2 = new Bebida("Coca-Cola 500ml", TamanioBebida.CHICO, 400.00, 150.00);

        Bebida bebida3 = new Bebida("Fanta 3l", TamanioBebida.GRANDE, 1200.00, 800.00);
        Bebida bebida4 = new Bebida("Fanta 1,5l", TamanioBebida.MEDIANO, 700.00, 300.00);
        Bebida bebida5 = new Bebida("Fanta 500ml", TamanioBebida.CHICO, 400.00, 150.00);
        
        Bebida bebida6 = new Bebida("Sprite 3l", TamanioBebida.GRANDE, 1200.00, 800.00);
        Bebida bebida7 = new Bebida("Sprite 1,5l", TamanioBebida.MEDIANO, 700.00, 300.00);
        Bebida bebida8 = new Bebida("Sprite 500ml", TamanioBebida.CHICO, 400.00, 150.00);
        
        Bebida bebida9 = new Bebida("Pepsi 3l", TamanioBebida.GRANDE, 1000.00, 700.00);
        Bebida bebidaA = new Bebida("Pepsi 1,5l", TamanioBebida.MEDIANO, 600.00, 400.00);
        Bebida bebidaB = new Bebida("Pepsi 500ml", TamanioBebida.CHICO, 500.00, 300.00);
        
        Bebida bebidaC = new Bebida("7up 3l", TamanioBebida.GRANDE, 1000.00, 700.00);
        Bebida bebidaD = new Bebida("7up 1,5l", TamanioBebida.MEDIANO, 600.00, 400.00);
        Bebida bebidaE = new Bebida("7up 500ml", TamanioBebida.CHICO, 500.00, 300.00);
        

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
        Acompanamiento cream = new Acompanamiento("Crema");
        Salsa sauce =new Salsa("Fileto");
        Salsa sauce1 =new Salsa("Pesto genovés");
        Salsa sauce2 =new Salsa("Carbonara");
        Salsa sauce3 =new Salsa("Bolognesa");
        Salsa sauce4 =new Salsa("Mixta");
        Salsa sauce5 =new Salsa("Blanca");


        PlatoM plato0 = (new PlatoM("Milanesa", 4000.0,1500.0, TipoPlato.CARNE));
        plato0.addAcompanamiento(pure);
        PlatoM plato1 = new PlatoM("Pechuga de pollo", 3500.0,2000.0, TipoPlato.CARNE);
        plato1.addAcompanamiento(pureB);
        PlatoM plato2 = new PlatoM("Costilla de cerdo", 5000.0,4000.0, TipoPlato.CARNE);
        plato2.addAcompanamiento(salad);
        plato2.addAcompanamiento(pure);

        PlatoM plato3 = new PlatoM("Canelones", 2500.0,2000.0, TipoPlato.PASTA);
        plato3.addSalsa(sauce);
        PlatoM plato4 = new PlatoM("Sorrentinos", 2000.0,1300.0, TipoPlato.PASTA);
        plato4.addSalsa(sauce);
        plato4.addSalsa(sauce1);
        PlatoM plato5 = new PlatoM("Fettuccini", 2000.0,1300.0, TipoPlato.PASTA);
        plato5.addSalsa(sauce4);
        PlatoM plato6 = new PlatoM("Ñoquis", 1800.0,1300.0, TipoPlato.PASTA);
        plato6.addSalsa(sauce5);

        PlatoM plato7 = new PlatoM("Salmon", 6500.0,4000.0, TipoPlato.PESCADO);
        plato7.addAcompanamiento(rise);
        PlatoM plato8 = new PlatoM("Dorado", 5500.0, 3500.0, TipoPlato.PESCADO);
        plato8.addAcompanamiento(rise);
        PlatoM plato9 = new PlatoM("Trucha", 5000.0,3500.0, TipoPlato.PESCADO);
        plato9.addAcompanamiento(pureB);
        PlatoM platoA = new PlatoM("Pejerrey", 5000.0,3500.0, TipoPlato.PESCADO);
        platoA.addAcompanamiento(rise);

        PlatoM platoB = new PlatoM("Tiramisu", 1500.0,400.0, TipoPlato.POSTRE);
        PlatoM platoC = new PlatoM("Budín de chocolate", 1300.0,800.0, TipoPlato.POSTRE);
        platoC.addAcompanamiento(honey);
        PlatoM platoD = new PlatoM("Flan", 1600.0,312.0, TipoPlato.POSTRE);
        platoD.addAcompanamiento(cream);
        PlatoM platoE = new PlatoM("3 Bochas de helado", 1400.0,543.0, TipoPlato.POSTRE);

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

        menu.setBebidas(bebidasMenu);
        menu.setPlatos(platosMenu);
        return menu;
    }

    private Orden generarOrden(){
        Bebida bebida10 = new Bebida("Quilmes 1Lt", TamanioBebida.GRANDE, 800.00, 0.0);
        Bebida bebida11 = new Bebida("Red Bull", TamanioBebida.CHICO, 700.00, 0.0);
        List<Bebida> bebidas2 = new ArrayList<>();
        bebidas2.add(bebida10);
        bebidas2.add(bebida11);

        Plato plato = new Plato("Porcion Vacio", 4000.00,0.0, TipoPlato.CARNE);
        plato.setAcompanamiento(new Acompanamiento("Papas Fritas"));

        Plato platox = new Plato("Tallarines", 3000.00,0.0, TipoPlato.PASTA);
        platox.setSalsa(new Salsa("Bolognesa"));
        List<Plato> platos2 = new ArrayList<>();
        platos2.add(plato);
        platos2.add(platox);

        return orderDao.save(new Orden(bebidas2, platos2));
    }

    private List<Mesa> crearMesas(Integer n, Menu menu){
        List<Mesa> res = new ArrayList<>();
        for (int i = 0; i < n; i++) { res.add(new Mesa(menu.getId())); }
        return res;
    }
}
