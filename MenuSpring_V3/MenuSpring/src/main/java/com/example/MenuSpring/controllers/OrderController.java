package com.example.MenuSpring.controllers;

import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.entities.ClientOrder;
import com.example.MenuSpring.services.MenuService;
import com.example.MenuSpring.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final Logger log= LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<ClientOrder> findAllOrders(){

        return orderService.findAll();
    }
    @PostMapping
    public ResponseEntity<ClientOrder> addOrder(@RequestBody ArrayList<Long> order){
       return orderService.add(order);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientOrder> findById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND
        ).body("Trying to add a non existent dish");
    }

}
