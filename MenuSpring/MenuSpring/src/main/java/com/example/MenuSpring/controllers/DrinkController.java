package com.example.MenuSpring.controllers;

import com.example.MenuSpring.entities.Drink;
import com.example.MenuSpring.entities.Poke;
import com.example.MenuSpring.repositories.DrinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrinkController {
    private final Logger log = LoggerFactory.getLogger(DrinkController.class);
    private DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }
    @GetMapping("/api/drinks")
    public List<Drink> findAll(){
        return drinkRepository.findAll();
    }

    @GetMapping("/api/drink")
    public ResponseEntity<Drink> create(@RequestBody Drink drink){
        if(drink.getId()!=null){
            log.warn("Trying to create a drink with id");
            return ResponseEntity.badRequest().build();
        }
        Drink result= drinkRepository.save(drink);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/api/drink")
    public ResponseEntity<Drink> insert(@RequestBody Drink drink){
        if(drink.getId()!=null){
            log.warn("Trying to create a drink with id");
            return ResponseEntity.badRequest().build();
        }
        Drink result= drinkRepository.save(drink);
        return ResponseEntity.ok(result);
    }
}
