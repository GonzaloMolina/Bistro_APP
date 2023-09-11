package Bistro_BackEnd.model.Menu;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Consumible;
import Bistro_BackEnd.model.consumibles.Plato;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plato> platos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bebida> bebidas = new ArrayList<>();
    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Menu() {
    }

    // Constructor con parámetros
    public Menu(List<Plato> platos, List<Bebida> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    public Long getId() {
        return id;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
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
