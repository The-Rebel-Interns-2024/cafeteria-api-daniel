package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.ClientOrder;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import com.example.MenuSpring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService implements OrderServiceInterface{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MenuRepository menuRepository;
    @Override
    public List<ClientOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public ResponseEntity<ClientOrder> add(ArrayList<Long> menus) {
        List<Menu> menusToday= menuRepository.findMenuToday(LocalDate.now());
        ArrayList<Menu> validMenus= new ArrayList<>();
        Double totalPrice= 0.0;
        for(Long id: menus){
            for(Menu m: menusToday){
                if(m.getMenuId().equals(id)){
                    validMenus.add(m);
                    totalPrice+= m.getPrice();
                }
            }
        }
        return ResponseEntity.ok(orderRepository.save(new ClientOrder(null,totalPrice, validMenus )));
    }

    @Override
    public ClientOrder findById( Long id) {
        return orderRepository.findById(id).get();
    }
}
