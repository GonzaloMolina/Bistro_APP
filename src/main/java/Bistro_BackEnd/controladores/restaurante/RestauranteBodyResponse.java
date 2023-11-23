package Bistro_BackEnd.controladores.restaurante;

import Bistro_BackEnd.controladores.empleado.MozoResponseBody;
import Bistro_BackEnd.controladores.empleado.PeticionBodyResponseList;
import Bistro_BackEnd.controladores.menu.MenuResponseBody;
import Bistro_BackEnd.controladores.mesa.MesaBodyResponseList;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponseList;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.mesa.Mesa;
import Bistro_BackEnd.model.restaurante.Restaurante;

import java.util.List;
import java.util.stream.Collectors;

public class RestauranteBodyResponse {

    private String name;
    private String admin;
    private String email;
    private String tel;
    private String direccion;
    private MenuResponseBody menu;
    private List<MozoResponseBody> empleados;
    private List<OrdenBodyResponseList> ordenes;
    private List<PeticionBodyResponseList> solicitudes;
    private List<MesaBodyResponseList> mesas;

    public RestauranteBodyResponse(Restaurante restaurante) {
        this.name = restaurante.getRestoName();
        this.admin = restaurante.getAdminName();
        this.email = restaurante.getEmail();
        this.tel = restaurante.getPhone();
        this.direccion = restaurante.getDirection();
        this.empleados = this.mapEmpleados(restaurante.getEmpleados());
        this.ordenes = this.mapOrdenes(restaurante.getOrdenes());
        this.solicitudes = this.mapSolicitudes(restaurante.getSolicitudes());
        this.mesas = this.mapMesas(restaurante.getMesas());
        this.menu = this.mapMenu(restaurante.getMenu());
    }

    private MenuResponseBody mapMenu(Menu menu) {
        return new MenuResponseBody(menu);
    }

    private List<MesaBodyResponseList> mapMesas(List<Mesa> mesas) {
        return mesas.stream().map(MesaBodyResponseList::new).collect(Collectors.toList());
    }

    private List<PeticionBodyResponseList> mapSolicitudes(List<Solicitud> solicitudes) {
        return solicitudes.stream().map(PeticionBodyResponseList::new).collect(Collectors.toList());
    }

    private List<OrdenBodyResponseList> mapOrdenes(List<Orden> ordenes) {
        return ordenes.stream().map(OrdenBodyResponseList::new).collect(Collectors.toList());
    }

    private List<MozoResponseBody> mapEmpleados(List<Mozo> empleados) {
        return empleados.stream().map(MozoResponseBody::new).collect(Collectors.toList());
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAdmin() { return admin; }

    public void setAdmin(String admin) { this.admin = admin; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<MozoResponseBody> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<MozoResponseBody> empleados) {
        this.empleados = empleados;
    }

    public List<OrdenBodyResponseList> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenBodyResponseList> ordenes) {
        this.ordenes = ordenes;
    }

    public List<PeticionBodyResponseList> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<PeticionBodyResponseList> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<MesaBodyResponseList> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaBodyResponseList> mesas) {
        this.mesas = mesas;
    }

    public MenuResponseBody getMenu() {
        return menu;
    }

    public void setMenu(MenuResponseBody menu) {
        this.menu = menu;
    }
}
