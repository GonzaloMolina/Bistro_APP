package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.model.consumibles.TipoPlato;
import Bistro_BackEnd.model.menu.PlatoM;

import java.util.List;
import java.util.stream.Collectors;

public class MenuElemP {

    private TipoPlato type;
    private List<PlatoMBodyResponse> content;

    public MenuElemP(TipoPlato type, List<PlatoM> lsPlatesM) {
        this.type = type;
        this.content = this.mapLs(lsPlatesM);
    }

    public List<PlatoMBodyResponse> mapLs(List<PlatoM> ls){
        return ls.stream().map(PlatoMBodyResponse::new).collect(Collectors.toList());
    }

    public TipoPlato getType() {
        return type;
    }

    public void setType(TipoPlato type) {
        this.type = type;
    }

    public List<PlatoMBodyResponse> getContent() {
        return content;
    }

    public void setContent(List<PlatoMBodyResponse> content) {
        this.content = content;
    }
}
