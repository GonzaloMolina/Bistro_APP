package Bistro_BackEnd.model.menu;

import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.consumibles.Acompanamiento;
import Bistro_BackEnd.model.consumibles.Consumible;
import Bistro_BackEnd.model.consumibles.Salsa;
import Bistro_BackEnd.model.consumibles.TipoPlato;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PlatoM extends Consumible {
    @Enumerated(EnumType.STRING)
    private TipoPlato tipo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Acompanamiento> acompanamientos;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Salsa> salsas;

    public PlatoM() {
    }

    // Constructor
    public PlatoM(String nombre, double precio, TipoPlato tipo) {
        super(nombre, precio);
        this.tipo = tipo;
        this.acompanamientos= new ArrayList<>();
        this.salsas= new ArrayList<>();
    }

    // Constructor
    public PlatoM(String nombre, double precio, TipoPlato tipo, List<Acompanamiento> acomps, List<Salsa> salsas) {
        super(nombre, precio);
        this.tipo = tipo;
        this.acompanamientos = acomps;
        this.salsas = salsas;
    }

    //Getters
    public TipoPlato getTipo() {
        return tipo;
    }

    public List<Acompanamiento> getAcompanamiento() {
        return this.acompanamientos;
    }

    public List<Salsa> getSalsa(){
        return this.salsas;
    }

    //Setters
    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setSalsa(List<Salsa> salsa){
        this.salsas = salsa;
    }

    public void setAcompanamiento(List<Acompanamiento> acompanamiento) {
        this.acompanamientos = acompanamiento;
    }

    public void addAcompanamiento(Acompanamiento acomp){
        this.acompanamientos.add(acomp);
    }

    public void addSalsa(Salsa salsa){
        this.salsas.add(salsa);
    }

    public Acompanamiento getAcompanamiento(Long acomValue) {
        return
            this.acompanamientos
                .stream()
                    .filter(acompanamiento ->
                            acompanamiento.getId().equals(acomValue))
                    .collect(Collectors.toList()).get(0);
    }

    public Salsa getSalsa(Long value) {
        return
            this.salsas
                .stream()
                    .filter(salsa ->
                            salsa.getId().equals(value))
                    .collect(Collectors.toList()).get(0);
    }
}
