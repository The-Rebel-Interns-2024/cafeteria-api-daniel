package com.example.MenuSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "Menus")
public class Menu implements Serializable {

    @Id
    private LocalDate date;
    @Column
    private ArrayList<String> mainDishes;
    @Column
    private ArrayList<String> pokes;
    @Column
    private ArrayList<String> drinks;
    @Column
    private Double price;

    public Menu( ArrayList<String> mainDishes) {
        ArrayList<String> drinks= new ArrayList<>();
        drinks.add("Coca cola");
        drinks.add("Mahou");
        drinks.add( "Agua");
        ArrayList<String> pokes= new ArrayList<>();
        String[] ing1= {"Pasta","Arroz","Quinoa","Lechuga"};
        String[] ing2= {"Vegetal", "Atun","Pollo"};
        for (String s : ing1) {
            for (String string : ing2) {
                pokes.add(s + " " + string);
            }
        }
        this.date = LocalDate.now();
        this.mainDishes = mainDishes;
        this.pokes = pokes;
        this.drinks = drinks;
        this.price = 6.9;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", mainDishes=" + mainDishes +
                ", pokes=" + pokes +
                ", drinks=" + drinks +
                ", price=" + price +
                '}';
    }

    public Menu() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<String> getMainDishes() {
        return mainDishes;
    }

    public void setMainDishes(ArrayList<String> mainDishes) {
        this.mainDishes = mainDishes;
    }

    public ArrayList<String> getPokes() {
        return pokes;
    }

    public void setPokes(ArrayList<String> pokes) {
        this.pokes = pokes;
    }

    public ArrayList<String> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
