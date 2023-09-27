package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.model.pair.Pair;
import Bistro_BackEnd.model.pair.PairPlatoAcom;

import java.util.List;

public class OrdenBodyPost {

    private Integer mozoId;
    private Integer mesaId;
    private List<Pair> bebidas;
    private List<PairPlatoAcom> platos;

    public OrdenBodyPost(){}//cambiar list por unitario

    public OrdenBodyPost(Integer mozoId, Integer mesaId, List<Pair> bebidas, List<PairPlatoAcom> platos){
        this.mozoId = mozoId;
        this.mesaId = mesaId;
        this.bebidas = bebidas;
        this.platos = platos;
    }

    public Integer getMozoId() {
        return mozoId;
    }

    public void setMozoId(Integer mozoId) {
        this.mozoId = mozoId;
    }

    public Integer getMesaId() {
        return mesaId;
    }

    public void setMesaId(Integer mesaId) {
        this.mesaId = mesaId;
    }

    public List<Pair> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Pair> bebidas) {
        this.bebidas = bebidas;
    }

    public List<PairPlatoAcom> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PairPlatoAcom> platos) {
        this.platos = platos;
    }
}
