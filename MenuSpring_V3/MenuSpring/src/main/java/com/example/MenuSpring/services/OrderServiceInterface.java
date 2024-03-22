package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.ClientOrder;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface OrderServiceInterface {
    public List<ClientOrder> findAll();
    public ResponseEntity<ClientOrder> add(ArrayList<Long> menus);
    public ClientOrder findById( Long id);
}
