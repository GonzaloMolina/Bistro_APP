package Bistro_BackEnd.controladores.consumibles;

import Bistro_BackEnd.model.consumibles.Acompanamiento;

public class AcompanamientoBodyResponse {

    private Long id;
    private String nombre;

    public AcompanamientoBodyResponse() {}

    public AcompanamientoBodyResponse(Acompanamiento acompanamiento) {
        this.id = acompanamiento.getId();
        this.nombre = acompanamiento.getNombre();
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
