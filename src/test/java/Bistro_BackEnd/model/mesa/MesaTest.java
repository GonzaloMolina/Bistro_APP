package Bistro_BackEnd.model.mesa;

import Bistro_BackEnd.model.Orden.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    private Mesa mesa = new Mesa();
    private Mesa mesa1;
    private Orden dumyOrden;

    @BeforeEach
    void setUp(){
        mesa1 = new Mesa();
        mesa1.setId(1L);
        mesa1.setCapacidad(4);
        mesa1.setCuenta(10.0);
        mesa1.setOrden(dumyOrden);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(mesa.getId());
        assertNull(mesa.getOrden());
        assertNull(mesa.getCuenta());
        assertEquals(mesa.getCapacidad(), 0);
    }

    @Test
    void test_01_getId(){
        assertEquals(mesa1.getId(), 1L);
    }

    @Test
    void test_02_getCapacidad(){
        assertEquals(mesa1.getCapacidad(), 4);
    }

    @Test
    void test_03_getCuenta(){
        assertEquals(mesa1.getCuenta(), 10.0);
    }

    @Test
    void test_04_getOrden(){
        assertEquals(mesa1.getOrden(), dumyOrden);
    }

    @Test
    void test_05_setId(){
        mesa1.setId(2L);
        assertEquals(mesa1.getId(), 2L);
    }

    @Test
    void test_06_setCapacidad(){
        mesa1.setCapacidad(2);
        assertEquals(mesa1.getCapacidad(), 2);
    }

    @Test
    void test_07_setCuenta(){
        mesa1.setCuenta(0.0);
        assertEquals(mesa1.getCuenta(), 0.0);
    }

    @Test
    void test_08_setOrden(){
        mesa1.setOrden(new Orden());
        assertFalse(mesa1.getOrden() == dumyOrden);
    }
}
