package com.example.MenuSpring;

import com.example.MenuSpring.entities.MainDish;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.entities.Poke;
import com.example.MenuSpring.repositories.MenuRepository;
import com.example.MenuSpring.repositories.PokeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

import java.util.ArrayList;

@SpringBootApplication()
public class MenuSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(MenuSpringApplication.class, args);
		MenuRepository mr= context.getBean(MenuRepository.class);
		String dish1= "Pasta boloñesa";
		String dish2= "Filete de ternera con patatas";
		String dish3= "Arroz con pollo";
		System.out.println(mr.findAll().size());
		ArrayList<String> dishes= new ArrayList<>();
		dishes.add(dish1);
		dishes.add(dish2);
		dishes.add(dish3);
		Menu menu= new Menu(dishes);
		System.out.println(menu.getMainDishes().toString());
		mr.save(menu);
		System.out.println(mr.findAll().size());
		System.out.println(mr);

	}
}
