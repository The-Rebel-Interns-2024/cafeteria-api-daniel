package com.example.MenuSpring.controllers;
import com.example.MenuSpring.entities.MainDish;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import com.example.MenuSpring.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final Logger log= LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/today")
    public List<Menu> findTodaysMenu(){
        MenuService ms= new MenuService();
        return ms.findToday(menuRepository);
    }
    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody ArrayList<MainDish> dishes){
        MenuService ms= new MenuService();
        for(MainDish md: dishes){
            Menu menu= new Menu(null, md.getName(),md.getPrice());
            ms.add(menuRepository,menu);
        }
        return null;
    }

}
