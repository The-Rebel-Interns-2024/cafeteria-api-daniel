package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;

public interface MenuServiceInterface {
    public List<Menu> findAll(MenuRepository menuRepository);
    public ResponseEntity<Menu> add(MenuRepository menuRepository,Menu menu);
    public List<Menu> findToday(MenuRepository menuRepository);
}
