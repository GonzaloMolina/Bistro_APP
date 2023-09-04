package Bistro_BackEnd.model.Orden;

import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.mesa.Mesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrdenTest {

    private Orden ord = new Orden();
    private Orden ord1;
    private List<Bebida> bebidas = new ArrayList<>();
    private List<Plato> platos = new ArrayList<>();

    @BeforeEach
    void setUp(){
        ord1 = new Orden(bebidas, platos);
    }

    @Test
    void test_00_construrtorVacio(){
        assertNull(ord.getId());
        assertNull(ord.getBebidas());
        assertNull(ord.getPlatos());
        assertNull(ord.getMesa());
    }

    @Test
    void test_01_constructorParametrizado(){
        assertNull(ord1.getId());
        assertNull(ord1.getMesa());
        assertEquals(ord1.getBebidas(), bebidas);
        assertEquals(ord1.getPlatos(), platos);
    }

    @Test
    void test_02_setId(){
        ord1.setId(1L);
        assertEquals(ord1.getId(), 1L);
    }

    @Test
    void test_03_setMesa(){
        Mesa temp = new Mesa();
        ord1.setMesa(temp);
        assertEquals(ord1.getMesa(), temp);
    }

    @Test
    void test_04_setBebidas(){
        ord.setBebida(bebidas);
        assertEquals(ord.getBebidas(), bebidas);
    }

    @Test
    void test_05_setPlatos(){
        ord.setPlato(platos);
        assertEquals(ord.getPlatos(), platos);
    }
}
