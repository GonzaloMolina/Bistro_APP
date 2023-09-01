package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.Orden.Orden;

public class OrdenBodyResponse {

    private Long id;

    public OrdenBodyResponse() {}

    public OrdenBodyResponse(Orden orden){
        this.id = orden.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
