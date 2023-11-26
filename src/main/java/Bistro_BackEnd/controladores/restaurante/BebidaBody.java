package Bistro_BackEnd.controladores.restaurante;

public class BebidaBody {
    private String admin;
    private String nombre;
    private double precio;
    private double cost;
    private String tamanio;

    public BebidaBody(){}
    public BebidaBody(String admin, String nombre, double precio, double cost, String tamanio){
        this.admin = admin;
        this.nombre = nombre;
        this.precio = precio;
        this.cost = cost;
        this.tamanio = tamanio;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
