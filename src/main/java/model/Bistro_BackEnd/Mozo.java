package model.Bistro_BackEnd;

import javax.persistence.*;
import java.util.List; // Importa la clase List si usas List

@Entity
public class Mozo extends Empleado {

    @OneToMany(mappedBy = "mozo")
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
