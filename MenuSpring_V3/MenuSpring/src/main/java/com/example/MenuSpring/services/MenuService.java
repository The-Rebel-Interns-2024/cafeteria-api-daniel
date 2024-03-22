package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService implements MenuServiceInterface {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu add(MenuDTO menuDTO
    ) {
        return menuRepository.save(new Menu(null, menuDTO.getName(), menuDTO.getPrice()));
    }

    @Override
    public List<Menu> findToday() {
        List<Menu> menus= findAll();
        List<Menu> today= new ArrayList<>();
        for(Menu menu:menus){
            if(menu.getDate().equals(LocalDate.now())){
                today.add(menu);
            }
        }
        return today;
    }
}
