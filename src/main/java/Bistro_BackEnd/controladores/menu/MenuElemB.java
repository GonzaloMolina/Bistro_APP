package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.controladores.consumibles.BebidaBodyResponse;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.TamanioBebida;

import java.util.List;
import java.util.stream.Collectors;

public class MenuElemB {

    private TamanioBebida type;
    private List<BebidaBodyResponse> content;

    public MenuElemB(TamanioBebida type, List<Bebida> lsBebida) {
        this.type = type;
        this.content = this.mapLs(lsBebida);
    }

    public List<BebidaBodyResponse> mapLs(List<Bebida> ls){
        return ls.stream().map(BebidaBodyResponse::new).collect(Collectors.toList());
    }


    public TamanioBebida getType() {
        return type;
    }

    public void setType(TamanioBebida type) {
        this.type = type;
    }

    public List<BebidaBodyResponse> getContent() {
        return content;
    }

    public void setContent(List<BebidaBodyResponse> content) {
        this.content = content;
    }
}
