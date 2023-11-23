package Bistro_BackEnd.controladores.restaurante;

public class RestauranteBody {
    private String adminName;
    private String restoName;
    private String email;
    private String password;
    private String phone;
    private String direction;

    public RestauranteBody() {}

    public RestauranteBody(String adminNombre, String restoNombre, String emailAdmin, String password, String tel, String dir) {
        this.adminName = adminNombre;
        this.restoName = restoNombre;
        this.email = emailAdmin;
        this.password = password;
        this.phone = tel;
        this.direction = dir;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
