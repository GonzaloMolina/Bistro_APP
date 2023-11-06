package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.model.empleado.Estado;
import Bistro_BackEnd.model.empleado.Solicitud;

public class PeticionBodyResponseList {

    private Long id;
    private String asunto;
    private Estado estado;

    public PeticionBodyResponseList(){}

    public PeticionBodyResponseList(Solicitud peticion) {
        this.id = peticion.getId();
        this.asunto = peticion.getAsuto();
        this.estado = peticion.getEstado();
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
