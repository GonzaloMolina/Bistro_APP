package Bistro_BackEnd.model.menu;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.consumibles.TipoPlato;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PlatoM> platos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Bebida> bebidas = new ArrayList<>();
    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Menu() {
    }

    // Constructor con parámetros
    public Menu(List<PlatoM> platos, List<Bebida> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    public Long getId() {
        return id;
    }

    public List<PlatoM> getPlatos() {
        return platos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlatos(List<PlatoM> platos) {
        this.platos = platos;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<TipoPlato> listTypesOfPlates(){
        List<TipoPlato> res=new ArrayList<>();
        this.platos.forEach(plt -> {
            if(!res.contains(plt.getTipo())){ res.add(plt.getTipo());}
        });
        return res;
    }

    public List<TamanioBebida> listTamanio() {
        List<TamanioBebida> res=new ArrayList<>();
        this.bebidas.forEach(drink -> {
            if(!res.contains(drink.getTamanio())){ res.add(drink.getTamanio());}
        });
        return res;
    }

    public void addPlate(PlatoM ptl) {
        this.platos.add(ptl);
    }

    public void deletePlato(Long id) {
        this.platos = this.platos.stream().filter(platoM -> !platoM.getId().equals(id)).collect(Collectors.toList());
    }

    public void deleteBebida(Long id) {
        this.bebidas = this.bebidas.stream().filter(bebida -> !bebida.getId().equals(id)).collect(Collectors.toList());
    }
}
