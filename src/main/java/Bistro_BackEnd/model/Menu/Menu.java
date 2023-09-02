package Bistro_BackEnd.model.Menu;
import Bistro_BackEnd.model.consumibles.Consumible;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany(mappedBy = "menu_id", cascade = CascadeType.ALL)
    //private List<Consumible> consumibles = new ArrayList<>();

    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Menu() {
    }

    // Constructor con parámetros
    //public Menu(List<Consumible> consumibles) {
    //    this.consumibles = consumibles;
    //}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public List<Consumible> getConsumibles() {
    //    return consumibles;
    //}

    //public void setConsumibles(List<Consumible> consumibles) {
//        this.consumibles = consumibles;
//    }
}
