package Bistro_BackEnd.model.empleado;

import Bistro_BackEnd.model.Mesa.Mesa;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List; // Importa la clase List si usas List

@Entity
public class Mozo extends Empleado {

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Mesa> mesasAsignadas;

    public Mozo() {
    }

    // Constructor
    public Mozo(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public List<Mesa> getMesasAsignadas() {
        return mesasAsignadas;
    }

    public void setMesasAsignadas(List<Mesa> mesasAsignadas) {
        this.mesasAsignadas = mesasAsignadas;
    }
}
