package com.example.MenuSpring.controllers;
import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Menu;
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
    private MenuService menuService;

    @GetMapping("/today")
    public ResponseEntity<List<MenuDTO>> findTodaysMenu(){
        List<Menu> menus= menuService.findToday();
        List<MenuDTO> repr= new ArrayList<>();
        for(Menu m: menus){
            repr.add(new MenuDTO(m.getName(), m.getPrice()));
        }
        return ResponseEntity.ok(repr);
    }
    @PostMapping
    public ResponseEntity<MenuDTO> addMenu(@RequestBody MenuDTO menuDTO){
        Menu menu =menuService.add(menuDTO);
        return ResponseEntity.ok(new MenuDTO(menu.getName(),menu.getPrice()));
    }

}
