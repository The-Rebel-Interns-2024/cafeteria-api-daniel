package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<ClientOrder,Long> {
    List<ClientOrder> findByOrderId(Long id);
}
