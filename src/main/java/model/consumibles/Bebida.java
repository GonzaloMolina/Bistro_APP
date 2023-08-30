package model.consumibles;
import model.Orden.Orden;

import javax.persistence.*;

@Entity
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    public Bebida() {
    }

    // Constructor
    public Bebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Orden getOrden() {
        return orden;
    }

    public double getPrecio() {
        return precio;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
