package Bistro_BackEnd.controladores.restaurante;

public class StateBody {

    private Long targetRequest;
    private String estado;

    public StateBody(){}

    public StateBody(Long id, String newState){
        this.targetRequest = id;
        this.estado= newState;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTargetRequest() {
        return targetRequest;
    }

    public void setTargetRequest(Long targetRequest) {
        this.targetRequest = targetRequest;
    }
}
