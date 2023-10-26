package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MozoTest {

    private Mozo emp = new Mozo();
    private Mozo emp1;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Restaurante res;

    @BeforeEach
    void setUp(){
        nombre = "Mike";
        apellido = "Ashton";
        email = "admin@mail.com";
        password ="public123";
        emp1 = new Mozo(nombre, apellido, email, password, res);
    }

    @Test
    void test_00_constructorVacio() {
        assertNull(emp.getId());
        assertNull(emp.getNombre());
        assertNull(emp.getApellido());
        assertNull(emp.getMesasAsignadas());
        assertNull(emp.getSolicitudes());
        assertNull(emp.getEmail());
        assertNull(emp.getPassword());
    }

    @Test
    void test_01_constructorParametrizado(){
        assertNull(emp1.getId());
        assertEquals(emp1.getNombre(), nombre);
        assertEquals(emp1.getApellido(), apellido);
        assertEquals(emp1.getMesasAsignadas().size(), 0);
        assertEquals(emp1.getSolicitudes().size(), 0);
        assertEquals(emp1.getEmail(), email);
        assertEquals(emp1.getPassword(), password);
    }

    @Test
    void test_02_setId(){
        emp1.setId(1L);
        assertEquals(emp1.getId(), 1L);
    }

    @Test
    void test_03_setNombre(){
        emp1.setNombre("");
        assertEquals(emp1.getNombre(), "");
    }

    @Test
    void test_04_setApellido(){
        emp1.setApellido("");
        assertEquals(emp1.getApellido(), "");
    }

    @Test
    void test_05_setMesasAsig(){
        List<Mesa> mesas = new ArrayList<>();
        emp1.setMesasAsignadas(mesas);
        assertEquals(emp1.getMesasAsignadas(), mesas);
    }

    @Test
    void test_06_setEmail(){
        emp1.setEmail("");
        assertEquals(emp1.getEmail(), "");
    }

    @Test
    void test_07_setEmail(){
        emp1.setPassword("");
        assertEquals(emp1.getPassword(), "");
    }

    @Test
    void test_08_setPeticiones(){
        List<Solicitud> peticiones = new ArrayList<>();
        emp1.setSolicitudes(peticiones);
        assertEquals(emp1.getSolicitudes(), peticiones);
    }

    @Test
    void test_09_addPeticion(){
        Solicitud pet = new Solicitud();
        emp1.addSolicitud(pet);
        assertFalse(emp1.getSolicitudes().isEmpty());
        assertEquals(emp1.getSolicitudes().get(0), pet);
    }

    @Test
    void test_09_getPeticion(){
        Solicitud pet = new Solicitud();
        pet.setId(1L);
        emp1.addSolicitud(pet);
        assertEquals(emp1.getSolicitud(1L), pet);
    }

    @Test
    void test_09_deletePeticion(){
        Solicitud pet = new Solicitud();
        pet.setId(1L);
        emp1.addSolicitud(pet);

        Solicitud pet1 = new Solicitud();
        pet1.setId(2L);
        emp1.addSolicitud(pet1);

        assertFalse(emp1.getSolicitudes().isEmpty());

        emp1.deleteSolicitud(1L);

        assertFalse(emp1.getSolicitudes().isEmpty());
        assertEquals(emp1.getSolicitudes().size(), 1);
    }
}
