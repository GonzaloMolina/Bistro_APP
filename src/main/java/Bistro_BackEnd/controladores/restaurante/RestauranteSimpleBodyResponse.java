package Bistro_BackEnd.controladores.restaurante;

import Bistro_BackEnd.model.restaurante.Restaurante;

public class RestauranteSimpleBodyResponse {
    private String nombreMarca;
    private String email;
    private String administrador;
    private String telefono;
    private String direccion;

    public RestauranteSimpleBodyResponse(Restaurante restaurante) {
        this.nombreMarca = restaurante.getRestoName();
        this.email = restaurante.getEmail();
        this.administrador = restaurante.getAdminName();
        this.telefono = restaurante.getPhone();
        this.direccion = restaurante.getDirection();
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
