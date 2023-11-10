package Bistro_BackEnd.controladores.restaurante;

public class DeleteBody {

    private Integer target;
    private String admin;

    public DeleteBody(){}

    public DeleteBody(String adminEmail, Integer target){
        this.admin = adminEmail;
        this.target = target;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
