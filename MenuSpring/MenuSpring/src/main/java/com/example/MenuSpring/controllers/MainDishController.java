package com.example.MenuSpring.controllers;

import com.example.MenuSpring.entities.MainDish;
import com.example.MenuSpring.repositories.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainDishController {
    private final Logger log= LoggerFactory.getLogger(MainDishController.class);
    private DishRepository dishRepository;

    public MainDishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }
    @GetMapping("/api/dishes/{id}")
    public ResponseEntity<MainDish> findById(@PathVariable Long id){
        Optional<MainDish> dish= dishRepository.findById(id);

        if(dish.isPresent())
            return ResponseEntity.ok(dish.get());
        else
            return ResponseEntity.notFound().build();

    }
    @PostMapping("api/dish")
    public ResponseEntity<MainDish> create(@RequestBody MainDish mainDish){
        if(mainDish.getId()!=null){
            log.warn("Trying to create a dish with an id");
            return ResponseEntity.badRequest().build();
        }
        MainDish result= dishRepository.save(mainDish);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("api/dish")
    public ResponseEntity<MainDish> delete(@PathVariable Long id){
        if(!dishRepository.existsById(id)){
            log.warn("Trying to delete a non existent dish");
            return ResponseEntity.notFound().build();
        }
        dishRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
