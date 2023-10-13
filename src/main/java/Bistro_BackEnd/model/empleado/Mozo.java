package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List; // Importa la clase List si usas List

@Entity
public class Mozo extends Empleado {

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Peticion> peticiones;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Mesa> mesasAsignadas;

    public Mozo() {
    }

    // Constructor
    public Mozo(String nombre, String apellido, String email, String password) {
        super(nombre, apellido, email, password);
        this.mesasAsignadas = new ArrayList<>();
        this.peticiones = new ArrayList<>();
    }

    public List<Mesa> getMesasAsignadas() {
        return mesasAsignadas;
    }

    public void setMesasAsignadas(List<Mesa> mesasAsignadas) {
        this.mesasAsignadas = mesasAsignadas;
    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

    public void addPeticion(Peticion peticion) {
        this.peticiones.add(0, peticion);
    }

    public Peticion getPeticion(long l) {
        return this.peticiones.stream().filter(pet -> pet.getId() == l).toList().get(0);
    }

    public void deletePeticion(long l) {
        this.peticiones = this.peticiones.stream().filter(pet -> pet.getId() != l).toList();
    }
}
