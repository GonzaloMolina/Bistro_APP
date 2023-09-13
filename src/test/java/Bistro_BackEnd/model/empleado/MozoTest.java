package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
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

    @BeforeEach
    void setUp(){
        nombre = "Mike";
        apellido = "Ashton";
        email = "admin@mail.com";
        password ="public123";
        emp1 = new Mozo(nombre, apellido, email, password);
    }

    @Test
    void test_00_constructorVacio() {
        assertNull(emp.getId());
        assertNull(emp.getNombre());
        assertNull(emp.getApellido());
        assertNull(emp.getMesasAsignadas());
        assertNull(emp.getPeticiones());
        assertNull(emp.getEmail());
        assertNull(emp.getPassword());
    }

    @Test
    void test_01_constructorParametrizado(){
        assertNull(emp1.getId());
        assertEquals(emp1.getNombre(), nombre);
        assertEquals(emp1.getApellido(), apellido);
        assertEquals(emp1.getMesasAsignadas().size(), 0);
        assertEquals(emp1.getPeticiones().size(), 0);
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
        List<Peticion> peticiones = new ArrayList<>();
        emp1.setPeticiones(peticiones);
        assertEquals(emp1.getPeticiones(), peticiones);
    }

    @Test
    void test_09_addPeticion(){
        Peticion pet = new Peticion();
        emp1.addPeticion(pet);
        assertFalse(emp1.getPeticiones().isEmpty());
        assertEquals(emp1.getPeticiones().get(0), pet);
    }

    @Test
    void test_09_getPeticion(){
        Peticion pet = new Peticion();
        pet.setId(1L);
        emp1.addPeticion(pet);
        assertEquals(emp1.getPeticion(1L), pet);
    }

    @Test
    void test_09_deletePeticion(){
        Peticion pet = new Peticion();
        pet.setId(1L);
        emp1.addPeticion(pet);

        Peticion pet1 = new Peticion();
        pet1.setId(2L);
        emp1.addPeticion(pet1);

        assertFalse(emp1.getPeticiones().isEmpty());

        emp1.deletePeticion(1L);

        assertFalse(emp1.getPeticiones().isEmpty());
        assertEquals(emp1.getPeticiones().size(), 1);
    }
}
