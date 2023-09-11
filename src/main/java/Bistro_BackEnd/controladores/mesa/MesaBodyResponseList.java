package Bistro_BackEnd.controladores.mesa;

import Bistro_BackEnd.model.mesa.Mesa;

public class MesaBodyResponseList {

    private Long id;
    private Integer capacidad;

    public MesaBodyResponseList(Mesa mesa) {
        this.id = mesa.getId();
        this.capacidad = mesa.getCapacidad();
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
}
