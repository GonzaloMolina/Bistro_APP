package Bistro_BackEnd.model.Orden;

import Bistro_BackEnd.model.consumibles.Consumible;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
public class Orden {

    @Id
    @Column(name = "orden_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Bebida> bebida;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Plato> plato;
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    public Orden(){}
    public Orden(List<Bebida> bebida, List<Plato> plato){
        this.bebida = bebida;
        this.plato = plato;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bebida> getBebidas() {
        return bebida;
    }

    public void setBebida(List<Bebida> bebida) {
        this.bebida = bebida;
    }

    public List<Plato> getPlatos() {
        return plato;
    }

    public void setPlato(List<Plato> plato) {
        this.plato = plato;
    }

    public Double calcularCuenta() {
        return this.bebida.stream().mapToDouble(Consumible::getPrecio).sum() +
                this.plato.stream().mapToDouble(Consumible::getPrecio).sum();

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        double res= 0.0;
        for (Plato value : this.plato) {
            res = Double.sum(res, value.getPrecio());
        }
        for (Bebida value : this.bebida) {
            res = Double.sum(res, value.getPrecio());
        }
        return res;
    }

    public double getCost() {
        double res= 0.0;
        for (Plato value : this.plato) {
            res = Double.sum(res, value.getCost());
        }
        for (Bebida value : this.bebida) {
            res = Double.sum(res, value.getCost());
        }
        return res;
    }
}
