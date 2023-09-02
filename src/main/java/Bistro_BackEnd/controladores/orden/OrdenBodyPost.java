package Bistro_BackEnd.controladores.orden;

import java.util.List;

public class OrdenBodyPost {

    private Integer mozoId;
    private Integer mesaId;
    private List<Integer> bebidas;
    private List<Integer> platos;

    public OrdenBodyPost(){}//cambiar list por unitario

    public OrdenBodyPost(Integer mozoId, Integer mesaId, List<Integer> bebidas, List<Integer> platos){
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

    //public List<Integer> getPlatos() {
    //    return platos;
    //}

    //public void setPlatos(List<Integer> platos) {
    //    this.platos = platos;
    //}

    public List<Integer> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Integer> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Integer> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Integer> platos) {
        this.platos = platos;
    }
}
