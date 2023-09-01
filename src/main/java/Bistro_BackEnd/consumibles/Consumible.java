package Bistro_BackEnd.consumibles;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Consumible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Consumible() {
    }

    // Constructor con parámetros
    public Consumible(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}