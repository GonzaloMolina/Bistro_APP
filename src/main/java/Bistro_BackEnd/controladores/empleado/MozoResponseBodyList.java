package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.empleado.Mozo;

public class MozoResponseBodyList {
    private Long id;
    private String nombre;
    private String apellido;

    public  MozoResponseBodyList(){}

    public MozoResponseBodyList(Mozo mozo){
        this.id = mozo.getId();
        this.nombre = mozo.getNombre();
        this.apellido = mozo.getApellido();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
