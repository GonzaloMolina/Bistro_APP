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
    @Column(name = "orden_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Mesa mesa;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Bebida> bebida;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Plato> plato;

    public Orden(){}
    public Orden(List<Bebida> bebida, List<Plato> plato){
        this.bebida = bebida;
        this.plato = plato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Bebida> getBebidas() {
        return bebida;
    }

    public void setBebida(List<Bebida> bebida) {
        this.bebida = bebida;
    }

    public List<Plato> getPlato() {
        return plato;
    }

    public void setPlato(List<Plato> plato) {
        this.plato = plato;
    }
}
