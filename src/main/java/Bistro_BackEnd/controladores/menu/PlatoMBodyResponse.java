package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.controladores.consumibles.AcompanamientoBodyResponse;
import Bistro_BackEnd.controladores.consumibles.SalsaBodyResponse;
import Bistro_BackEnd.model.consumibles.Acompanamiento;
import Bistro_BackEnd.model.consumibles.Salsa;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.menu.PlatoM;

import java.util.List;
import java.util.stream.Collectors;

public class PlatoMBodyResponse {

    private Long id;
    private String nombre;
    private double precio;
    private double cost;
    private TipoPlato tipo;
    private List<AcompanamientoBodyResponse> acompanamientos;
    private List<SalsaBodyResponse> salsas;

    public PlatoMBodyResponse(){}

    public PlatoMBodyResponse(PlatoM plato) {
        this.id = plato.getId();
        this.nombre = plato.getNombre();
        this.precio = plato.getPrecio();
        this.cost = plato.getCost();
        this.tipo = plato.getTipo();
        this.acompanamientos = this.mapAcompanamiento(plato.getAcompanamiento());
        this.salsas = this.mapSalsa(plato.getSalsa());
    }

    private List<SalsaBodyResponse> mapSalsa(List<Salsa> salsas) {
        return salsas.stream().map(SalsaBodyResponse::new).collect(Collectors.toList());
    }

    private List<AcompanamientoBodyResponse> mapAcompanamiento(List<Acompanamiento> acompanamientos) {
        return acompanamientos.stream().map(AcompanamientoBodyResponse::new).collect(Collectors.toList());
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

    public List<AcompanamientoBodyResponse> getAcompanamiento() {
        return this.acompanamientos;
    }

    public void setAcompanamiento(List<AcompanamientoBodyResponse> acompanamiento) {
        this.acompanamientos = acompanamiento;
    }

    public List<SalsaBodyResponse> getSalsa() {
        return this.salsas;
    }

    public void setSalsa(List<SalsaBodyResponse> salsa) {
        this.salsas = salsa;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
