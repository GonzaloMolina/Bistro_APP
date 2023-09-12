package Bistro_BackEnd.model.menu;

import Bistro_BackEnd.model.Menu.Menu;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MenuTest {

    private Menu menuE = new Menu();
    private Menu menu;

    @BeforeEach
    void setUp(){
        List<Bebida> drinks = new ArrayList<>();
        drinks.add(new Bebida());

        List<Plato> plates = new ArrayList<>();
        plates.add(new Plato());

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
        List<Plato> pls = new ArrayList<>();
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
}
