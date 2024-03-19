package com.example.MenuSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "poke")
public class Poke implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "name")
    private String name;

    public Poke(Long id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Poke() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
