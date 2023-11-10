package Bistro_BackEnd.controladores.restaurante;

public class MesaBody {

    private String adminEmail;
    private Integer capacidad;

    public MesaBody(){}

    public MesaBody(String adminEmail, Integer capacidad){
        this.adminEmail = adminEmail;
        this.capacidad = capacidad;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
