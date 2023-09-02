package Bistro_BackEnd.model.consumibles;

import javax.persistence.*;

@Entity
public class Acompanamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "plato_id")
    private Plato plato;

    public Acompanamiento() {
    }

    // Constructor
    public Acompanamiento(String nombre) {
        this.nombre = nombre;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
