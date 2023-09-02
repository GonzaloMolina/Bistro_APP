package Bistro_BackEnd.controladores.consumibles;

import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.TamanioBebida;

public class BebidaBodyResponse {

    private Long id;
    private String nombre;
    private double precio;
    private TamanioBebida tamanio;

    public BebidaBodyResponse(){}
    public BebidaBodyResponse(Bebida bebida){
        this.id = bebida.getId();
        this.nombre = bebida.getNombre();
        this.precio = bebida.getPrecio();
        this.tamanio = bebida.getTamanio();
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

    public TamanioBebida getTamanio() {
        return tamanio;
    }

    public void setTamanio(TamanioBebida tamanio) {
        this.tamanio = tamanio;
    }
}
