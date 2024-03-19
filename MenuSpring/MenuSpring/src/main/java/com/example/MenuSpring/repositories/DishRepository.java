package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.MainDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<MainDish,Long> {
}
