package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.model.Orden.Orden;

import java.time.LocalDate;

public class OrdenBodyResponseList {

    private Long id;
    private double price;
    private double cost;
    private LocalDate date;

    public OrdenBodyResponseList(){}

    public OrdenBodyResponseList(Orden orden){
        this.id = orden.getId();
        this.price = orden.getPrice();
        this.cost = orden.getCost();
        this.date = orden.getDate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
