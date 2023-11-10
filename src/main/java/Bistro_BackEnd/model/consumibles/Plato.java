package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.menu.PlatoM;

import javax.persistence.*;

@Entity
public class Plato extends Consumible {
    
    @Enumerated(EnumType.STRING)
    private TipoPlato tipo;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @OneToOne(cascade = CascadeType.ALL)
    private Acompanamiento acompanamiento;

    @OneToOne(cascade = CascadeType.ALL) // Solo si el plato es Pasta
    private Salsa salsa;

    public Plato() {
    }

    // Constructor
    public Plato(String nombre, double precio, double cost,TipoPlato tipo) {
        super(nombre, precio, cost);
        this.tipo = tipo;
    }

    // Constructor
    public Plato(String nombre, double precio, double cost, TipoPlato tipo, Acompanamiento acompanamiento, Salsa salsa) {
        super(nombre, precio, cost);
        this.tipo = tipo;
        this.acompanamiento = acompanamiento;
        this.salsa = salsa;
    }

    public Plato(PlatoM rPlato) {
        super(rPlato.getNombre(), rPlato.getPrecio(), rPlato.getCost());
        this.tipo = rPlato.getTipo();
    }

    //Getters
    public TipoPlato getTipo() {
        return tipo;
    }

    public Orden getOrden() {
        return orden;
    }

    public Acompanamiento getAcompanamiento() {
        return this.acompanamiento;
    }

    public Salsa getSalsa(){
        return this.salsa;
    }

    //Setters
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setSalsa(Salsa salsa){
        this.salsa = salsa;
    }

    public void setAcompanamiento(Acompanamiento acompanamiento) {
        this.acompanamiento = acompanamiento;
    }
}
