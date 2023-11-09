package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    private Bebida bebida = new Bebida();
    private Bebida beb;

    @BeforeEach
    void setUp(){
        beb = new Bebida("",TamanioBebida.CHICO, 1.0, 0.0);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(bebida.getId());
        assertNull(bebida.getNombre());
        assertNull(bebida.getTamanio());
        assertNull(bebida.getOrden());
        assertEquals(bebida.getPrecio(), 0);
    }
    @Test
    void test_01_constructorParametrizado(){
        assertNull(beb.getId());
        assertEquals(beb.getNombre(), "");
        assertEquals(beb.getTamanio(), TamanioBebida.CHICO);
        assertEquals(beb.getPrecio(), 1.0);
        assertNull(beb.getOrden());
    }
    @Test
    void test_02_setId(){
        beb.setId(1L);
        assertEquals(beb.getId(), 1L);
    }
    @Test
    void test_03_setNombre(){
        beb.setNombre("");
        assertEquals(beb.getNombre(), "");
    }
    @Test
    void test_04_setPrecio(){
        beb.setPrecio(2.0);
        assertEquals(beb.getPrecio(), 2.0);
    }
    @Test
    void test_05_setTamanio(){
        beb.setTamanio(TamanioBebida.MEDIANO);
        assertEquals(beb.getTamanio(), TamanioBebida.MEDIANO);
    }
    @Test
    void test_06_setOrden(){
        assertNull(beb.getOrden());
        beb.setOrden(new Orden());
        assertNotNull(beb.getOrden());
    }
}
