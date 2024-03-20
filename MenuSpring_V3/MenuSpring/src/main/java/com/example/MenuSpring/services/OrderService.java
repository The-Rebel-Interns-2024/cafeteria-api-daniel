package com.example.MenuSpring.services;

import com.example.MenuSpring.entities.Order;
import com.example.MenuSpring.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderService implements OrderServiceInterface{
    @Override
    public List<Order> findAll(OrderRepository orderRepository) {
        return orderRepository.findAll();
    }

    @Override
    public ResponseEntity<Order> add(OrderRepository orderRepository, Order order) {
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @Override
    public List<Order> findById(OrderRepository orderRepository, Long id) {
        return findById(orderRepository,id);
    }
}
