package com.example.MenuSpring.dto;

public class MenuDTO {
    private String name;
    private Double price;

    public MenuDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public MenuDTO() {
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
