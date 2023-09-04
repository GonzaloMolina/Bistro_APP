package Bistro_BackEnd.model.consumibles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcompanamientpTest {

    private Acompanamiento aco = new Acompanamiento();
    private Acompanamiento aco1;
    private String nombre;

    @BeforeEach
    void setUp(){
        nombre = "Salsa agridulce";
        aco1 = new Acompanamiento(nombre);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(aco.getId());
        assertNull(aco.getNombre());
        assertNull(aco.getPlato());
    }
    @Test
    void test_01_constructorParametrizado(){
        assertNull(aco.getId());
        assertEquals(aco1.getNombre(), nombre);
        assertNull(aco.getPlato());
    }
    @Test
    void test_02_setId(){
        aco1.setId(1L);
        assertEquals(aco1.getId(), 1L);
    }

    @Test
    void test_03_setNombre(){
        aco1.setNombre("");
        assertEquals(aco1.getNombre(), "");
    }

    @Test
    void test_04_setPlato(){
        assertNull(aco1.getPlato());
        aco1.setPlato(new Plato());
        assertNotNull(aco1.getPlato());
    }
}
