package Bistro_BackEnd.controladores.restaurante;

public class StateBody {

    private Long targetRequest;
    private String estado;
    private String adminEmail;

    public StateBody(){}

    public StateBody(Long id, String newState, String adminEmail){
        this.targetRequest = id;
        this.estado= newState;
        this.adminEmail= adminEmail;
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

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
