package Bistro_BackEnd.controladores.peticion;

public class PeticionBodyPost {

    private Integer empleadoId;
    private String destino;
    private String origen;
    private String asunto;
    private String body;

    public PeticionBodyPost(){}

    public PeticionBodyPost(Integer empleadoId, String destino, String origen, String asunto, String body){
        this.empleadoId = empleadoId;
        this.destino = destino;
        this.origen = origen;
        this.asunto = asunto;
        this.body = body;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
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

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
