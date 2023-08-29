package model.Bistro_BackEnd;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<Plato> platos;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
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
