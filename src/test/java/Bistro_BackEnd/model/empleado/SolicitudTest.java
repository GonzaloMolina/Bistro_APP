package Bistro_BackEnd.model.empleado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudTest {


    private Solicitud peticionE = new Solicitud();
    private Solicitud pet;

    private String receptor;
    private String emisor;
    private String asunto;
    private String cuerpo;

    @BeforeEach
    void setUp(){
        receptor = "admin@mail.com";
        emisor = "emp@mail.com";
        asunto = "Licencia por tratamiento medico";
        cuerpo = "";
        pet = new Solicitud(receptor, emisor, asunto, cuerpo);
    }

    @Test
    void test_00_constructorVacio() {
        assertNull(peticionE.getId());
        assertNull(peticionE.getReceptor());
        assertNull(peticionE.getEmisor());
        assertNull(peticionE.getAsuto());
        assertNull(peticionE.getCuerpo());
        assertSame(peticionE.getEstado(), null);
    }

    @Test
    void test_01_constructorParametrizado() {
        assertNull(pet.getId());
        assertEquals(pet.getReceptor(), receptor);
        assertEquals(pet.getEmisor(), emisor);
        assertEquals(pet.getAsuto(), asunto);
        assertEquals(pet.getCuerpo(), cuerpo);
        assertSame(pet.getEstado(), Estado.ENPROCESO);
    }

    @Test
    void test_02_setId() {
        assertNull(pet.getId());
        pet.setId(1L);
        assertEquals(pet.getId(), 1L);
    }

    @Test
    void test_03_setReceptor() {
        assertEquals(pet.getReceptor(), receptor);
        pet.setReceptor("");
        assertEquals(pet.getReceptor(), "");
    }

    @Test
    void test_04_setEmisor() {
        assertEquals(pet.getEmisor(), emisor);
        pet.setEmisor("");
        assertEquals(pet.getEmisor(), "");
    }

    @Test
    void test_05_setAsunto() {
        assertEquals(pet.getAsuto(), asunto);
        pet.setAsuto("");
        assertEquals(pet.getAsuto(), "");
    }

    @Test
    void test_06_setId() {
        assertEquals(pet.getCuerpo(), cuerpo);
        pet.setCuerpo("");
        assertEquals(pet.getCuerpo(), "");
    }

    @Test
    void test_07_setEstado() {
        assertNotSame(pet.getEstado(), Estado.ACEPTADA);
        pet.setEstado(Estado.ACEPTADA);
        assertSame(pet.getEstado(), Estado.ACEPTADA);
    }
}
