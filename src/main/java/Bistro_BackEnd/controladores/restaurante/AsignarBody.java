package Bistro_BackEnd.controladores.restaurante;

public class AsignarBody {

    private String admin;
    private Integer mesaId;
    private Integer empleadoId;

    public AsignarBody(){}
    public AsignarBody(String adminEmail, Integer mesaId, Integer emplId){
        this.admin = adminEmail;
        this.mesaId = mesaId;
        this.empleadoId = emplId;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Integer getMesaId() {
        return mesaId;
    }

    public void setMesaId(Integer mesaId) {
        this.mesaId = mesaId;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
