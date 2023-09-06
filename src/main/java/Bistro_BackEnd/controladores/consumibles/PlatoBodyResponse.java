package Bistro_BackEnd.controladores.consumibles;

import Bistro_BackEnd.model.consumibles.Acompanamiento;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.consumibles.Salsa;
import Bistro_BackEnd.model.consumibles.TipoPlato;

public class PlatoBodyResponse {

    private Long id;
    private String nombre;
    private double precio;
    private TipoPlato tipo;
    private AcompanammientoBodyResponse acompanamiento;
    private SalsaBodyResponse salsa;

    public PlatoBodyResponse(){}

    public PlatoBodyResponse(Plato plato) {
        this.id = plato.getId();
        this.nombre = plato.getNombre();
        this.precio = plato.getPrecio();
        this.tipo = plato.getTipo();
        this.acompanamiento = this.mapAcompanamiento(plato.getAcompanamiento());
        this.salsa = this.mapSalsa(plato.getSalsa());
    }

    private SalsaBodyResponse mapSalsa(Salsa salsa) {
        if(salsa != null){
            return new SalsaBodyResponse(salsa);
        }
        else{
            return null;
        }
    }

    private AcompanammientoBodyResponse mapAcompanamiento(Acompanamiento acompanamiento) {
        if(acompanamiento != null){
            return new AcompanammientoBodyResponse(acompanamiento);
        }
        else{
            return null;
        }
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

    public AcompanammientoBodyResponse getAcompanamiento() {
        return acompanamiento;
    }

    public void setAcompanamiento(AcompanammientoBodyResponse acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    public SalsaBodyResponse getSalsa() {
        return salsa;
    }

    public void setSalsa(SalsaBodyResponse salsa) {
        this.salsa = salsa;
    }

}
