package com.example.MenuSpring.controllers;

import com.example.MenuSpring.entities.Drink;
import com.example.MenuSpring.entities.Poke;
import com.example.MenuSpring.repositories.PokeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokeController {
    private final Logger log= LoggerFactory.getLogger(PokeController.class);
    private PokeRepository pokeRepository;

    public PokeController(PokeRepository pokeRepository) {
        this.pokeRepository = pokeRepository;
    }
    @GetMapping("/api/pokes")
    public List<Poke> findAll(){
        return pokeRepository.findAll();
    }

    @PostMapping("/api/poke")
    public ResponseEntity<Poke> insert(@RequestBody Poke poke){
        if(poke.getId()!=null){
            log.warn("Trying to create a poke with id");
            return ResponseEntity.badRequest().build();
        }
        Poke result= pokeRepository.save(poke);
        return ResponseEntity.ok(result);
    }
}
