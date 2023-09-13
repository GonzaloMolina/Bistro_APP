package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.controladores.consumibles.BebidaBodyResponse;
import Bistro_BackEnd.controladores.consumibles.PlatoBodyResponse;
import Bistro_BackEnd.model.Menu.Menu;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;

import java.util.List;
import java.util.stream.Collectors;

public class MenuResponseBody {

    private List<BebidaBodyResponse> bebidasR;
    private List<PlatoBodyResponse> platosR;

    public MenuResponseBody(Menu menu) {
        this.platosR = this.mapPlatos(menu.getPlatos());
        this.bebidasR = this.mapBebidas(menu.getBebidas());
    }

    private List<BebidaBodyResponse> mapBebidas(List<Bebida> bebidas) {
        return bebidas.stream().map(BebidaBodyResponse::new).collect(Collectors.toList());
    }

    private List<PlatoBodyResponse> mapPlatos(List<Plato> platos) {
        return platos.stream().map(PlatoBodyResponse::new).collect(Collectors.toList());
    }

    public List<BebidaBodyResponse> getBebidasR() {
        return bebidasR;
    }

    public void setBebidasR(List<BebidaBodyResponse> bebidasR) {
        this.bebidasR = bebidasR;
    }

    public List<PlatoBodyResponse> getPlatosR() {
        return platosR;
    }

    public void setPlatosR(List<PlatoBodyResponse> platosR) {
        this.platosR = platosR;
    }
}
