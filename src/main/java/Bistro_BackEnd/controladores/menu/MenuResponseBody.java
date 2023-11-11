package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.menu.Menu;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.menu.PlatoM;

import java.util.List;
import java.util.stream.Collectors;

public class MenuResponseBody {

    private List<MenuElemB> bebidasR;
    private List<MenuElemP> platosR;

    public MenuResponseBody(Menu menu) {
        this.platosR = this.mapPlates(menu.listTypesOfPlates(), menu.getPlatos());
        this.bebidasR = this.mapDrinks(menu.listTamanio(), menu.getBebidas());
    }

    private List<MenuElemB> mapDrinks(List<TamanioBebida> ts, List<Bebida> bebidas) {
        return ts.stream().map(t -> {
            List<Bebida> temp = bebidas.stream()
                .filter(drink -> drink.getTamanio() == t)
                    .collect(Collectors.toList());
            return new MenuElemB(t, temp);
        }).collect(Collectors.toList());
    }

    private List<MenuElemP> mapPlates(List<TipoPlato> ts, List<PlatoM> platos) {
        return ts.stream().map(t -> {
                List<PlatoM> temp = platos.stream().filter(platoM -> platoM.getTipo() == t).collect(Collectors.toList());
                return new MenuElemP(t, temp);
            }
        ).collect(Collectors.toList());
    }

    public List<MenuElemB> getBebidasR() {
        return bebidasR;
    }

    public void setBebidasR(List<MenuElemB> bebidasR) {
        this.bebidasR = bebidasR;
    }

    public List<MenuElemP> getPlatosR() {
        return platosR;
    }

    public void setPlatosR(List<MenuElemP> platosR) {
        this.platosR = platosR;
    }
}
