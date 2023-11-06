package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.restaurante.Restaurante;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List; // Importa la clase List si usas List

@Entity
public class Mozo extends Empleado {

    @ManyToOne
    private Restaurante restaurante;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Solicitud> solicitudes;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Mesa> mesasAsignadas;

    public Mozo() {
    }

    // Constructor
    public Mozo(String nombre, String apellido, String email, String password, Restaurante resto) {
        super(nombre, apellido, email, password);
        this.mesasAsignadas = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
        this.restaurante = resto;
    }

    public List<Mesa> getMesasAsignadas() {
        return mesasAsignadas;
    }

    public void setMesasAsignadas(List<Mesa> mesasAsignadas) {
        this.mesasAsignadas = mesasAsignadas;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void addSolicitud(Solicitud peticion) {
        this.solicitudes.add(peticion);
    }

    public Solicitud getSolicitud(long l) {
        return this.solicitudes.stream().filter(pet -> pet.getId() == l).toList().get(0);
    }

    public void deleteSolicitud(long l) {
        this.solicitudes = this.solicitudes.stream().filter(pet -> pet.getId() != l).toList();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
