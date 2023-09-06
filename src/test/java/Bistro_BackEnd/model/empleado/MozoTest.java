package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class MozoTest {

    private Mozo emp = new Mozo();
    private Mozo emp1;
    private String nombre;
    private String apellido;

    @BeforeEach
    void setUp(){
        nombre = "Mike";
        apellido = "Ashton";
        emp1 = new Mozo(nombre, apellido);
    }

    @Test
    void test_00_constructorVacio() {
        assertNull(emp.getId());
        assertNull(emp.getNombre());
        assertNull(emp.getApellido());
        assertNull(emp.getMesasAsignadas());
    }

    @Test
    void test_01_constructorParametrizado(){
        assertNull(emp1.getId());
        assertEquals(emp1.getNombre(), nombre);
        assertEquals(emp1.getApellido(), apellido);
        assertEquals(emp1.getMesasAsignadas().size(), 0);
    }

    @Test
    void test_02_setId(){
        emp1.setId(1L);
        assertEquals(emp1.getId(), 1L);
    }

    @Test
    void test_03_setNombre(){
        emp1.setNombre("");
        assertEquals(emp1.getNombre(), "");
    }

    @Test
    void test_04_setApellido(){
        emp1.setApellido("");
        assertEquals(emp1.getApellido(), "");
    }

    @Test
    void test_05_setMesasAsig(){
        List<Mesa> mesas = new ArrayList<>();
        emp1.setMesasAsignadas(mesas);
        assertEquals(emp1.getMesasAsignadas(), mesas);
    }
}
