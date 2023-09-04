package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PlatoTest {

    private Plato plato = new Plato();
    private Plato pla;

    @BeforeEach
    void setUp(){
        pla = new Plato("Salmon", 0.0, TipoPlato.PESCADO);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(plato.getId());
        assertNull(plato.getNombre());
        assertNull(plato.getTipo());
        assertNull(plato.getOrden());
        assertNull(plato.getSalsa());
        assertEquals(plato.getAcompanamientos().size(), 0);
        assertEquals(plato.getPrecio(), 0);
    }
    @Test
    void test_01_constructorParametrizado(){
        assertNull(pla.getId());
        assertNull(pla.getOrden());
        assertNull(plato.getSalsa());
        assertEquals(pla.getAcompanamientos().size(), 0);
        assertEquals(pla.getNombre(), "Salmon");
        assertEquals(pla.getTipo(), TipoPlato.PESCADO);
        assertEquals(pla.getPrecio(), 0.0);
    }
    @Test
    void test_0_setId(){
        assertNull(pla.getSalsa());
    }
    @Test
    void test_02_setId(){
        pla.setId(1L);
        assertEquals(pla.getId(), 1L);
    }
    @Test
    void test_03_setOrden(){
        assertNull(pla.getOrden());
        pla.setOrden(new Orden());
        assertNotNull(pla.getOrden());
    }
    @Test
    void test_04_setAcompaniamiento(){
        pla.setAcompanamientos(new ArrayList<>());
        assertNotNull(pla.getAcompanamientos());
    }
    @Test
    void test_05_setNombre(){
        pla.setNombre("");
        assertEquals(pla.getNombre(), "");
    }
    @Test
    void test_06_setTipo(){
        pla.setTipo(TipoPlato.CARNE);
        assertEquals(pla.getTipo(), TipoPlato.CARNE);
    }
    @Test
    void test_07_setPrecio(){
        pla.setPrecio(11.0);
        assertEquals(pla.getPrecio(), 11.0);
    }
    @Test
    void test_08_setSalsa(){
        assertNull(pla.getSalsa());
        pla.setSalsa(new Salsa());
        assertNotNull(pla.getSalsa());
    }
}
