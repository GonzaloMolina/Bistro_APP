package Bistro_BackEnd.model.consumibles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalsaTest {

    private Salsa salsa = new Salsa();
    private Salsa salsa1;
    private String nombre = "Salsa Teriyaki";

    @BeforeEach
    void setUp(){
        salsa1 = new Salsa(nombre);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(salsa.getId());
        assertNull(salsa.getNombre());
        assertNull(salsa.getPlato());
    }
    @Test
    void test_01_constructorParametrizado(){
        assertNull(salsa1.getId());
        assertNull(salsa1.getPlato());
        assertEquals(salsa1.getNombre(), nombre);
    }
    @Test
    void test_02_setId(){
        salsa1.setId(1L);
        assertEquals(salsa1.getId(), 1L);
    }
    @Test
    void test_03_setNombre(){
        salsa1.setNombre("");
        assertEquals(salsa1.getNombre(), "");
    }
    @Test
    void test_04_setPlato(){
        assertNull(salsa1.getPlato());
        salsa1.setPlato(new Plato());
        assertNotNull(salsa1.getPlato());
    }
}
