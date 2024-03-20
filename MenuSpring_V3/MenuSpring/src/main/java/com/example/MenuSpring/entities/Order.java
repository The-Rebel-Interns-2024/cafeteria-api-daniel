package com.example.MenuSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private ArrayList<Menu> dishes;
    @Column
    private Double totalPrice;

    public Order() {
    }

    public Order(Long id, ArrayList<Menu> dishes) {
        this.id = id;
        this.dishes = dishes;
        Double price= 0.0;
        for(Menu m: dishes){
            price+=m.getPrice();
        }
        this.totalPrice= price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Menu> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Menu> dishes) {
        this.dishes = dishes;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
