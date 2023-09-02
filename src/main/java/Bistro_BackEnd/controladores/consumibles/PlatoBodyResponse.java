package Bistro_BackEnd.controladores.consumibles;

import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.consumibles.TipoPlato;

public class PlatoBodyResponse {

    private Long id;
    private String nombre;
    private double precio;
    private TipoPlato tipo;

    public PlatoBodyResponse(){}

    public PlatoBodyResponse(Plato plato) {
        this.id = plato.getId();
        this.nombre = plato.getNombre();
        this.precio = plato.getPrecio();
        this.tipo = plato.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }
}
