package com.example.MenuSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Drinks")
public class Drink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Drink(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Drink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
