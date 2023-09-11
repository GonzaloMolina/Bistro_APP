package Bistro_BackEnd.controladores.mesa;

import Bistro_BackEnd.controladores.orden.OrdenBodyResponse;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.mesa.Mesa;

public class MesaBodyResponse {

    private Long id;
    private Integer capacidad;
    private double cuenta;
    private OrdenBodyResponse orden;

    public MesaBodyResponse(Mesa mesaR) {
        this.id = mesaR.getId();
        this.capacidad = mesaR.getCapacidad();
        this.cuenta = mesaR.getCuenta();
        this.orden = this.mapOrden(mesaR.getOrden());
    }

    private OrdenBodyResponse mapOrden(Orden orden) {
        if(orden == null){
            return null;
        }else{
            return new OrdenBodyResponse(orden);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    public OrdenBodyResponse getOrden() {
        return orden;
    }

    public void setOrden(OrdenBodyResponse orden) {
        this.orden = orden;
    }
}
