package Bistro_BackEnd.model.restaurante;

import Bistro_BackEnd.controladores.restaurante.RestauranteBody;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.empleado.Mozo;
import Bistro_BackEnd.model.empleado.Solicitud;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.mesa.Mesa;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Restaurante {

    @Id
    private String email;
    private String restoName;
    private String adminName;
    private String password;
    private String phone;
    private String direction;
    @OneToOne
    private Menu menu;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Solicitud> solicitudes = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mesa> mesas = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Orden> ordenes = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mozo> empleados = new ArrayList<>();

    public Restaurante() {}

    public Restaurante(String adminNombre, String restoNombre, String emailAdmin, String password, String tel, String dir) {
        this.adminName = adminNombre;
        this.restoName = restoNombre;
        this.email = emailAdmin;
        this.password = password;
        this.phone = tel;
        this.direction = dir;
        this.menu = new Menu();
    }

    public Restaurante(RestauranteBody body) {
        this.adminName = body.getAdminName();
        this.restoName = body.getRestoName();
        this.email = body.getEmail();
        this.password = body.getPassword();
        this.phone = body.getPhone();
        this.direction = body.getDirection();
        this.menu = new Menu();
    }

    //GETTERS
    public String getAdminName() { return adminName; }
    public String getRestoName() { return restoName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDirection() { return direction; }
    public String getPassword() {return password; }
    public List<Solicitud> getSolicitudes() { return solicitudes; }
    public List<Mesa> getMesas() { return mesas; }
    public List<Orden> getOrdenes() { return ordenes; }
    public List<Mozo> getEmpleados() { return empleados; }

    //SETTERS
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public void setRestoName(String restoName) { this.restoName = restoName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDirection(String direction) { this.direction = direction; }
    public void setPassword(String password) { this.password = password; }
    public void setSolicitudes(ArrayList<Solicitud> solicitudes) { this.solicitudes = solicitudes; }
    public void setMesas(ArrayList<Mesa> mesas) { this.mesas = mesas; }
    public void setOrdenes(List<Orden> ordenes) { this.ordenes = ordenes; }
    public void setEmpleados(ArrayList<Mozo> empleados) { this.empleados = empleados; }

    //LISTs
    public void addEmpleado(Mozo mozo) { empleados.add(mozo); }
    public void addMesa(Mesa mesa) { mesas.add(mesa); }
    public void addOrden(Orden orden) { ordenes.add(orden); }
    public void addSolicitud(Solicitud solicitud) { solicitudes.add(solicitud); }

    public void deleteEmpleado(Mozo mozo) {
        empleados = empleados.stream().filter(m -> !m.getId().equals(mozo.getId()))
                .collect(Collectors.toList());
    }

    public void deleteMesa(Mesa mesa) {
        mesas = mesas.stream().filter(m -> !m.getId().equals(mesa.getId())).collect(Collectors.toList());
    }

    public void deleteOrden(Orden orden) {
        ordenes = ordenes.stream().filter(o -> !o.getId().equals(orden.getId())).collect(Collectors.toList());
    }

    public void deleteSolicitud(Solicitud solicitud) {
        solicitudes = solicitudes.stream().filter(s -> !s.getId().equals(solicitud.getId())).collect(Collectors.toList());
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
