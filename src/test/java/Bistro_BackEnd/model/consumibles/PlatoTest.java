package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PlatoTest {

    private Plato plato = new Plato();
    private Plato pla;
    private Plato plt;
    private Acompanamiento acom;
    private Salsa sauce;

    @BeforeEach
    void setUp(){
        pla = new Plato("Salmon", 0.0, TipoPlato.PESCADO);
        plt = new Plato("s", 0.1, TipoPlato.CARNE, acom, sauce);
    }

    @Test
    void test_00_constructorVacio(){
        assertNull(plato.getId());
        assertNull(plato.getNombre());
        assertNull(plato.getTipo());
        assertNull(plato.getOrden());
        assertNull(plato.getSalsa());
        assertNull(plato.getAcompanamiento());
        assertEquals(plato.getPrecio(), 0);
    }
    @Test
    void test_01_constructorParametrizado(){
        assertNull(pla.getId());
        assertNull(pla.getOrden());
        assertNull(pla.getSalsa());
        assertNull(pla.getAcompanamiento());
        assertEquals(pla.getNombre(), "Salmon");
        assertEquals(pla.getTipo(), TipoPlato.PESCADO);
        assertEquals(pla.getPrecio(), 0.0);
    }
    @Test
    void test_0_constructorParametrizado(){
        assertNull(plt.getId());
        assertNull(plt.getOrden());
        assertEquals(plt.getSalsa(), sauce);
        assertEquals(plt.getAcompanamiento(), acom);
        assertEquals(plt.getNombre(), "s");
        assertEquals(plt.getTipo(), TipoPlato.CARNE);
        assertEquals(plt.getPrecio(), 0.1);
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
        Acompanamiento acompanamiento = new Acompanamiento("Papas Fritas");
        pla.setAcompanamiento(acompanamiento);
        assertNotNull(pla.getAcompanamiento());
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
        Salsa s = new Salsa();
        plato.setTipo(TipoPlato.PASTA);
        assertNull(plato.getSalsa());
        plato.setSalsa(s);
        assertEquals(s, plato.getSalsa());
    }
}
