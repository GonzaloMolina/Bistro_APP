package Bistro_BackEnd.controladores.peticion;

import Bistro_BackEnd.model.empleado.Peticion;

public class PeticionBodyResponse {

    private Long id;
    private String receptor;
    private String emisor;
    private String asunto;
    private String body;
    private boolean estado;

    public PeticionBodyResponse(){}

    public PeticionBodyResponse(Peticion pet) {
        this.id = pet.getId();
        this.receptor = pet.getReceptor();
        this.emisor = pet.getEmisor();
        this.asunto = pet.getAsuto();
        this.body = pet.getCuerpo();
        this.estado = pet.estaAprobado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
