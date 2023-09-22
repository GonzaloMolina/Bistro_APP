package Bistro_BackEnd.model.menu;

import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MenuTest {

    private Menu menuE = new Menu();
    private Menu menu;

    @BeforeEach
    void setUp(){
        List<Bebida> drinks = new ArrayList<>();
        Bebida b = new Bebida();
        b.setTamanio(TamanioBebida.MEDIANO);
        drinks.add(b);

        List<PlatoM> plates = new ArrayList<>();
        PlatoM p = new PlatoM();
        p.setTipo(TipoPlato.PESCADO);
        plates.add(p);

        menu = new Menu(plates, drinks);
    }

    @Test
    void test_00_constructorVacio() {
        assertNull(menuE.getId());
        assertEquals(menuE.getPlatos().size(), 0);
        assertEquals(menuE.getBebidas().size(), 0);
    }

    @Test
    void test_01_constructorParametrizado() {
        assertNull(menu.getId());
        assertEquals(menu.getPlatos().size(), 1);
        assertEquals(menu.getBebidas().size(), 1);
    }

    @Test
    void test_02_setPlatos() {
        List<PlatoM> pls = new ArrayList<>();
        menu.setPlatos(pls);
        assertEquals(menu.getPlatos(), pls);
    }

    @Test
    void test_03_setBebidas() {
        List<Bebida> bls = new ArrayList<>();
        menu.setBebidas(bls);
        assertEquals(menu.getBebidas(), bls);
    }

    @Test
    void test_04_setId() {
        Long id = 1L;
        menu.setId(id);
        assertEquals(menu.getId(), id);
    }

    @Test
    void test_05_listTypesOfPlates() {
        assertEquals(menu.listTamanio().size(), 1);
        assertEquals(menu.listTamanio().get(0), TamanioBebida.MEDIANO);
    }

    @Test
    void test_06_listTamanio() {
        assertEquals(menu.listTypesOfPlates().size(), 1);
        assertEquals(menu.listTypesOfPlates().get(0), TipoPlato.PESCADO);
    }
}
