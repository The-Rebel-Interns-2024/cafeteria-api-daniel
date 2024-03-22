package com.example.MenuSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class ClientOrder implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column
    private Double totalPrice;
    @ManyToMany(mappedBy = "clientOrders")
    private List<Menu> menus= new ArrayList<>();

    public ClientOrder() {
    }
    public Long getId() {
        return orderId;
    }

    public void setId(Long id) {
        this.orderId = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ClientOrder(Long id, Double totalPrice, List<Menu> menus) {
        this.orderId = id;
        this.totalPrice = totalPrice;
        this.menus = menus;
    }
}
