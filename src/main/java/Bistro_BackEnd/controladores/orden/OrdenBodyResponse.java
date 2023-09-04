package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.controladores.consumibles.BebidaBodyResponse;
import Bistro_BackEnd.controladores.consumibles.PlatoBodyResponse;
import Bistro_BackEnd.model.Orden.Orden;
import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;

import java.util.List;
import java.util.stream.Collectors;

public class OrdenBodyResponse {


    private Long id;
    private List<BebidaBodyResponse> bebidas;
    private List<PlatoBodyResponse> platos;

    public OrdenBodyResponse() {}

    public OrdenBodyResponse(Orden orden){
        this.id = orden.getId();
        this.platos = this.mapPlatos(orden.getPlatos());
        this.bebidas = this.mapBebidas(orden.getBebidas());
    }

    private  List<BebidaBodyResponse> mapBebidas(List<Bebida> bebidas) {
        return bebidas.stream().map(BebidaBodyResponse::new).collect(Collectors.toList());
    }

    private  List<PlatoBodyResponse> mapPlatos(List<Plato> platos) {
        return platos.stream().map(PlatoBodyResponse::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<BebidaBodyResponse> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<BebidaBodyResponse> bebidas) {
        this.bebidas = bebidas;
    }

    public List<PlatoBodyResponse> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlatoBodyResponse> platos) {
        this.platos = platos;
    }
}
