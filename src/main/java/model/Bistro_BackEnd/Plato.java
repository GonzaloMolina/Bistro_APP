package model.Bistro_BackEnd;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private String tipo; // Por ejemplo, "Pasta", "Carne", "Pescado", etc.

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @OneToMany(mappedBy = "plato", cascade = CascadeType.ALL)
    private List<Acompanamiento> acompanamientos = new ArrayList<>();

    @OneToOne(mappedBy = "plato", cascade = CascadeType.ALL) // Solo si el plato es Pasta
    private Salsa salsa;

    public Plato() {
    }

    // Constructor
    public Plato(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Orden getOrden() {
        return orden;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Acompanamiento> getAcompanamientos() {
        return acompanamientos;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSalsa(Salsa salsa){
        this.salsa = salsa;
    }

    public void setAcompanamientos(List<Acompanamiento> acompanamientos) {
        this.acompanamientos = acompanamientos;
    }
}
