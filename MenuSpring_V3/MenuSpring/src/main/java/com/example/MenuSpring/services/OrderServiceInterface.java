package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.Order;
import com.example.MenuSpring.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderServiceInterface {
    public List<Order> findAll(OrderRepository orderRepository);
    public ResponseEntity<Order> add(OrderRepository orderRepository, Order order);
    public List<Order> findById(OrderRepository orderRepository, Long id);
}
