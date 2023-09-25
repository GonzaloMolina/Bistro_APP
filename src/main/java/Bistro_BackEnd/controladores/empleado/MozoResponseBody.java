package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.controladores.peticion.PeticionBodyResponse;
import Bistro_BackEnd.model.empleado.Peticion;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.empleado.Mozo;

import java.util.List;
import java.util.stream.Collectors;

public class MozoResponseBody {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private List<Long> mesas;
    private List<PeticionBodyResponseList> peticiones;

    public MozoResponseBody(){}

    public MozoResponseBody(Mozo mozo){
        this.id = mozo.getId();
        this.nombre = mozo.getNombre();
        this.apellido = mozo.getApellido();
        this.email = mozo.getEmail();
        this.mesas = this.mapMesas(mozo.getMesasAsignadas());
        this.peticiones = this.mapPeticiones(mozo.getPeticiones());
    }

    private List<Long> mapMesas(List<Mesa> mesasAsignadas) {
        return mesasAsignadas.stream().map(Mesa::getId).collect(Collectors.toList());
    }

    private List<PeticionBodyResponseList> mapPeticiones(List<Peticion> peticiones){
        return peticiones.stream().map(PeticionBodyResponseList::new).collect(Collectors.toList());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PeticionBodyResponseList> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<PeticionBodyResponseList> peticiones) {
        this.peticiones = peticiones;
    }
}
