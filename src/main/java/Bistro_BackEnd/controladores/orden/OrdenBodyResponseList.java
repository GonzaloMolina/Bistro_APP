package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.Orden.Orden;

public class OrdenBodyResponseList {

    private Long id;

    public OrdenBodyResponseList(){}

    public OrdenBodyResponseList(Orden orden){
        this.id = orden.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
