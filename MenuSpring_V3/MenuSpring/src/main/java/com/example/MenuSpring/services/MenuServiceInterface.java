package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;

public interface MenuServiceInterface {
    public List<Menu> findAll();
    public Menu add(MenuDTO menuDTO);
    public List<Menu> findToday();
}
