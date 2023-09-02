package Bistro_BackEnd.controladores.orden;

import java.util.List;

public class OrdenBodyPost {

    private Integer mozoId;
    private Integer mesaId;
    private List<Integer> platos;
    private List<Integer> bebidas;

    public OrdenBodyPost(){}
    public OrdenBodyPost(Integer mozoId, Integer mesaId, List<Integer> platos, List<Integer> bebidas){
        this.mozoId = mozoId;
        this.mesaId = mesaId;
        this.platos = platos;
        this.bebidas = bebidas;
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

    public List<Integer> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Integer> platos) {
        this.platos = platos;
    }

    public List<Integer> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Integer> bebidas) {
        this.bebidas = bebidas;
    }
}
