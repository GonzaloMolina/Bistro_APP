package Bistro_BackEnd.controladores.restaurante;

public class PlatoBody {

    private String admin;
    private String nombre;
    private double precio;
    private double cost;
    private String tipo;
    private String acompaniamiento;

    public PlatoBody(){}
    public PlatoBody(String admin, String nombre, double precio, double cost, String tipo, String acompaniamiento){
        this.admin = admin;
        this.nombre = nombre;
        this.precio = precio;
        this.cost = cost;
        this.tipo = tipo;
        this.acompaniamiento = acompaniamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(String acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
