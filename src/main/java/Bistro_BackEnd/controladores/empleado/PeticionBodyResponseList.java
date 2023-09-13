package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.model.empleado.Peticion;

public class PeticionBodyResponseList {

    private Long id;
    private String asunto;
    private boolean estado;

    public PeticionBodyResponseList(){}

    public PeticionBodyResponseList(Peticion peticion) {
        this.id = peticion.getId();
        this.asunto = peticion.getAsuto();
        this.estado = peticion.estaAprobado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
