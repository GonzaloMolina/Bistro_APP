package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.empleado.Mozo;

import java.util.List;
import java.util.stream.Collectors;

public class MozoResponseBody {

    private Long id;
    private String nombre;
    private String apellido;
    private List<Long> mesas;

    public MozoResponseBody(){}

    public MozoResponseBody(Mozo mozo){
        this.id = mozo.getId();
        this.nombre = mozo.getNombre();
        this.apellido = mozo.getApellido();
        this.mesas = this.mapMesas(mozo.getMesasAsignadas());
    }

    private List<Long> mapMesas(List<Mesa> mesasAsignadas) {
        return mesasAsignadas.stream().map(Mesa::getId).collect(Collectors.toList());
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

    public List<Long> getMesas() {
        return mesas;
    }

    public void setMesas(List<Long> mesas) {
        this.mesas = mesas;
    }
}
