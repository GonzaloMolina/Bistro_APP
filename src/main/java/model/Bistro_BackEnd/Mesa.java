package model.Bistro_BackEnd;
import javax.persistence.*;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capacidad;
    private Double cuenta;

    @ManyToOne
    @JoinColumn(name = "mozo_id")
    private Mozo mozo;

    @OneToOne(mappedBy = "mesa")
    private Orden orden;

    // Constructor vacío
    public Mesa() {
    }

    //Getters
    public Long getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Double getCuenta() {
        return cuenta;
    }

    public Orden getOrden() {
        return orden;
    }

    //Setters
    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCuenta(Double cuenta) {
        this.cuenta = cuenta;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
