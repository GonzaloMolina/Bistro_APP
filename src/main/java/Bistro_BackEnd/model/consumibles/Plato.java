package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;
import javax.persistence.*;

@Entity
public class Plato extends Consumible {
    
    @Enumerated(EnumType.STRING)
    private TipoPlato tipo;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @OneToOne(mappedBy = "plato", cascade = CascadeType.PERSIST)
    private Acompanamiento acompanamiento;

    @OneToOne(mappedBy = "plato", cascade = CascadeType.PERSIST) // Solo si el plato es Pasta
    private Salsa salsa;

    public Plato() {
    }

    // Constructor
    public Plato(String nombre, double precio, TipoPlato tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //Getters
    public TipoPlato getTipo() {
        return tipo;
    }

    public Orden getOrden() {
        return orden;
    }

    public Acompanamiento getAcompanamiento() {
        Acompanamiento acompanamientoPlato = null;
        if (this.getTipo() == TipoPlato.CARNE || this.getTipo() == TipoPlato.PESCADO) {
            acompanamientoPlato = acompanamiento;
        };
        return acompanamientoPlato;
    }

    public Salsa getSalsa(){
        Salsa salsaDelPlato = null;
        if (this.getTipo() == TipoPlato.PASTA) {
            salsaDelPlato = salsa;
        };
        return salsaDelPlato;
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
