package Bistro_BackEnd.model.restaurante;

import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.model.mesa.Mesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    private Restaurante resto;
    private Restaurante otroResto;

    private String adminNombre = "admin name";
    private String restoNombre = "Rest name";
    private String emailAdmin = "@mail.com";
    private String tel = "11-12341234";
    private String dir = "una direccion";
    private String password = "public123";

    @BeforeEach
    void setUp(){
        resto = new Restaurante();
        otroResto = new Restaurante(adminNombre, restoNombre, emailAdmin, password, tel, dir);
    }

    @Test
    void test_00_construrtorVacio(){
        assertNull(resto.getAdminName());
        assertNull(resto.getRestoName());
        assertNull(resto.getEmail());
        assertNull(resto.getPhone());
        assertNull(resto.getDirection());

        assertTrue(resto.getMesas().isEmpty());
        assertTrue(resto.getSolicitudes().isEmpty());
        assertTrue(resto.getEmpleados().isEmpty());
        assertTrue(resto.getOrdenes().isEmpty());
    }

    @Test
    void test_01_construrtorParametrizado(){
        assertNotNull(otroResto.getAdminName());
        assertNotNull(otroResto.getRestoName());
        assertNotNull(otroResto.getEmail());
        assertNotNull(otroResto.getPhone());
        assertNotNull(otroResto.getDirection());

        assertTrue(otroResto.getMesas().isEmpty());
        assertTrue(otroResto.getSolicitudes().isEmpty());
        assertTrue(otroResto.getEmpleados().isEmpty());
        assertTrue(otroResto.getOrdenes().isEmpty());
    }

    @Test
    void test_02_Setters(){
        otroResto.setAdminName("Axel LG");
        otroResto.setRestoName("3Dragones");
        otroResto.setEmail("axel.lopez.garabal@gmail.com");
        otroResto.setPhone("11-4242232");
        otroResto.setDirection("direccion");
        otroResto.setMesas(new ArrayList<>());
        otroResto.setOrdenes(new ArrayList<>());
        otroResto.setSolicitudes(new ArrayList<>());
        otroResto.setEmpleados(new ArrayList<>());

        assertNotEquals(otroResto.getAdminName(), adminNombre);
        assertEquals(otroResto.getAdminName(), "Axel LG");
        assertNotEquals(otroResto.getRestoName(), restoNombre);
        assertEquals(otroResto.getRestoName(), "3Dragones");
        assertNotEquals(otroResto.getEmail(), emailAdmin);
        assertEquals(otroResto.getEmail(), "axel.lopez.garabal@gmail.com");
        assertNotEquals(otroResto.getPhone(), tel);
        assertEquals(otroResto.getPhone(), "11-4242232");
        assertNotEquals(otroResto.getDirection(), dir);
        assertEquals(otroResto.getDirection(), "direccion");

        assertTrue(otroResto.getMesas().isEmpty());
        assertTrue(otroResto.getSolicitudes().isEmpty());
        assertTrue(otroResto.getEmpleados().isEmpty());
        assertTrue(otroResto.getOrdenes().isEmpty());
    }

    @Test
    void test_03_addElemToList(){
        otroResto.addEmpleado(new Mozo());
        otroResto.addMesa(new Mesa());
        otroResto.addOrden(new Orden());
        otroResto.addSolicitud(new Solicitud());

        assertFalse(otroResto.getMesas().isEmpty());
        assertFalse(otroResto.getSolicitudes().isEmpty());
        assertFalse(otroResto.getEmpleados().isEmpty());
        assertFalse(otroResto.getOrdenes().isEmpty());
    }

    @Test
    void test_04_deleteElemToList(){
        Mozo e = new Mozo();
        e.setId(0L);
        Mesa m = new Mesa();
        m.setId(0L);
        Orden o = new Orden();
        o.setId(0L);
        Solicitud s = new Solicitud();
        s.setId(0L);

        otroResto.addEmpleado(e);
        otroResto.addMesa(m);
        otroResto.addOrden(o);
        otroResto.addSolicitud(s);

        assertFalse(otroResto.getMesas().isEmpty());
        assertFalse(otroResto.getSolicitudes().isEmpty());
        assertFalse(otroResto.getEmpleados().isEmpty());
        assertFalse(otroResto.getOrdenes().isEmpty());

        otroResto.deleteEmpleado(e);
        otroResto.deleteMesa(m);
        otroResto.deleteOrden(o);
        otroResto.deleteSolicitud(s);

        assertTrue(otroResto.getMesas().isEmpty());
        assertTrue(otroResto.getSolicitudes().isEmpty());
        assertTrue(otroResto.getEmpleados().isEmpty());
        assertTrue(otroResto.getOrdenes().isEmpty());
    }
}
