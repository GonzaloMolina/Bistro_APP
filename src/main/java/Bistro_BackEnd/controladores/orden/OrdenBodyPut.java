package Bistro_BackEnd.controladores.orden;

import java.util.List;

public class OrdenBodyPut {

    private Integer mozoId;
    private Integer ordenId;
    private List<Integer> bebidas;
    private List<Integer> platos;

    public OrdenBodyPut(){}//cambiar list por unitario

    public OrdenBodyPut(Integer mozoId, Integer ordenId, List<Integer> bebidas, List<Integer> platos){
        this.mozoId = mozoId;
        this.ordenId = ordenId;
        this.bebidas = bebidas;
        this.platos = platos;
    }

    public Integer getMozoId() {
        return mozoId;
    }

    public void setMozoId(Integer mozoId) {
        this.mozoId = mozoId;
    }

    public Integer getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Integer ordenId) {
        this.ordenId = ordenId;
    }

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
