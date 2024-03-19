package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MenuService implements MenuServiceInterface {

    @Override
    public List<Menu> findAll(MenuRepository menuRepository) {
        return menuRepository.findAll();
    }

    @Override
    public ResponseEntity<Menu> add(MenuRepository menuRepository,Menu menu) {
        return ResponseEntity.ok(menuRepository.save(menu));
    }

    @Override
    public List<Menu> findToday(MenuRepository menuRepository) {
        List<Menu> menus= findAll(menuRepository);
        List<Menu> today= new ArrayList<>();
        for(Menu menu:menus){
            if(menu.getDate().equals(LocalDate.now())){
                today.add(menu);
            }
        }
        return today;
    }
}
