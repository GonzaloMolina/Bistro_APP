package Bistro_BackEnd.model.menu;

import Bistro_BackEnd.model.consumibles.Acompanamiento;
import Bistro_BackEnd.model.consumibles.Salsa;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class PlatoMTest {

    private PlatoM emptyPlt;
    private PlatoM plt1;
    private PlatoM plt2;
    private List<Salsa> sauce;
    private List<Acompanamiento> acom;

    @BeforeEach
    void setUp(){
        emptyPlt = new PlatoM();
        plt1 = new PlatoM("", 0.0, 0.0,TipoPlato.PESCADO);
        acom = new ArrayList<>();
        sauce = new ArrayList<>();
        plt2 = new PlatoM("s", 0.1, 0.0,TipoPlato.CARNE, acom, sauce);
    }

    @Test
    void test_00_EmptyConstructor() {
        assertNull(emptyPlt.getId());
        assertNull(emptyPlt.getNombre());
        assertNull(emptyPlt.getTipo());
        assertNull(emptyPlt.getSalsa());
        assertNull(emptyPlt.getAcompanamiento());
        assertEquals(emptyPlt.getPrecio(), 0);
    }
    @Test
    void test_01_SmallParamConstructor() {
        assertNull(plt1.getId());
        assertEquals(plt1.getNombre(), "");
        assertEquals(plt1.getTipo(), TipoPlato.PESCADO);
        assertEquals(plt1.getSalsa().size(), 0);
        assertEquals(plt1.getAcompanamiento().size(), 0);
        assertEquals(plt1.getPrecio(), 0);
    }
    @Test
    void test_02_ParamConstructor() {
        assertNull(plt2.getId());
        assertEquals(plt2.getNombre(), "s");
        assertEquals(plt2.getTipo(), TipoPlato.CARNE);
        assertEquals(plt2.getSalsa(), sauce);
        assertEquals(plt2.getAcompanamiento(), acom);
        assertEquals(plt2.getPrecio(), 0.1);
    }

    @Test
    void test_03_setId(){
        plt1.setId(1L);
        assertEquals(plt1.getId(), 1L);
    }
    @Test
    void test_04_setAcompaniamiento(){
        Acompanamiento acompanamiento = new Acompanamiento("Papas Fritas");
        acom.add(acompanamiento);
        plt1.setAcompanamiento(acom);
        assertEquals(plt1.getAcompanamiento().size(), 1);
        assertEquals(plt1.getAcompanamiento().get(0), acompanamiento);
    }
    @Test
    void test_05_setNombre(){
        plt1.setNombre("1");
        assertEquals(plt1.getNombre(), "1");
    }
    @Test
    void test_06_setTipo(){
        plt1.setTipo(TipoPlato.CARNE);
        assertEquals(plt1.getTipo(), TipoPlato.CARNE);
    }
    @Test
    void test_07_setPrecio(){
        plt1.setPrecio(11.0);
        assertEquals(plt1.getPrecio(), 11.0);
    }
    @Test
    void test_08_setSalsa(){
        Salsa s = new Salsa();
        sauce.add(s);
        plt1.setSalsa(sauce);
        assertEquals(s,plt1.getSalsa().get(0));
    }
    @Test
    void test_09_addSalsa(){
        Salsa s = new Salsa();
        plt1.addSalsa(s);
        assertEquals(s,plt1.getSalsa().get(0));
    }
    @Test
    void test_10_addAcompaniamiento(){
        Acompanamiento acompanamiento = new Acompanamiento("Papas Fritas");
        plt1.addAcompanamiento(acompanamiento);
        assertEquals(plt1.getAcompanamiento().size(), 1);
        assertEquals(plt1.getAcompanamiento().get(0), acompanamiento);
    }
}
