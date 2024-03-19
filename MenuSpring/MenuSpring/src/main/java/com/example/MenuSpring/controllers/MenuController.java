package com.example.MenuSpring.controllers;
import com.example.MenuSpring.entities.Drink;
import com.example.MenuSpring.entities.MainDish;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.entities.Poke;
import com.example.MenuSpring.repositories.MenuRepository;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MenuController {
    private final Logger log= LoggerFactory.getLogger(MenuController.class);
    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    @GetMapping("/api/menu/{date}")
    public ResponseEntity<Menu> findMenuByDate(@PathVariable LocalDate date){
        Optional<Menu> menu= menuRepository.findById(date);
        if(menu.isPresent())
            return ResponseEntity.ok(menu.get());
        else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/api/menu/today")
    public ResponseEntity<Menu> findTodaysMenu(){
        Optional<Menu> menu= menuRepository.findById(LocalDate.now());
        if(menu.isPresent())
            return ResponseEntity.ok(menu.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/menu")
    public ResponseEntity<Menu> addMenu(@RequestBody ArrayList<String> dishes){
        Menu menu= new Menu(dishes);
        Menu result= menuRepository.save(menu);
        return ResponseEntity.ok(result);
    }

}
