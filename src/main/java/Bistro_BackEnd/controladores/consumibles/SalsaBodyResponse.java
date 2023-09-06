package Bistro_BackEnd.controladores.consumibles;

import Bistro_BackEnd.model.consumibles.Salsa;

public class SalsaBodyResponse {

    private Long id;
    private String nombre;

    public SalsaBodyResponse(){}

    public SalsaBodyResponse(Salsa salsa) {
        this.id = salsa.getId();
        this.nombre = salsa.getNombre();
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
}
