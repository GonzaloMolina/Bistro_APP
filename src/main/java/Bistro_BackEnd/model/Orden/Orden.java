package Bistro_BackEnd.model.Orden;

import Bistro_BackEnd.model.Mesa.Mesa;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@OneToMany(mappedBy = "orden", cascade = CascadeType.MERGE)
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Plato> platos;

    //@OneToMany(mappedBy = "orden", cascade = CascadeType.MERGE)
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Bebida> bebidas;

    @OneToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Orden() {
    }

    // Constructor 
    public Orden(List<Plato> platos, List<Bebida> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    //Setters
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
}
