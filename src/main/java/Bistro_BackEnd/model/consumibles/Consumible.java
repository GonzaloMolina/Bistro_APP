package Bistro_BackEnd.model.consumibles;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Consumible {

    @Id
    @Column(name = "consumible_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private double precio;
    private double cost;

    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Consumible() {
    }

    // Constructor con parámetros
    public Consumible(String nombre, double precio, double cost) {
        this.nombre = nombre;
        this.precio = precio;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}