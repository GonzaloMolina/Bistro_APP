package Bistro_BackEnd.controladores.restaurante;

public class MozoBody {

    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private String restoEmail;

    public MozoBody(){}

    public MozoBody(String nombre, String apellido, String mail, String password, String restoEmail){
        this.nombre = nombre;
        this.apellido = nombre;
        this.mail = nombre;
        this.password = nombre;
        this.restoEmail = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRestoEmail() {
        return restoEmail;
    }

    public void setRestoEmail(String restoEmail) {
        this.restoEmail = restoEmail;
    }
}
