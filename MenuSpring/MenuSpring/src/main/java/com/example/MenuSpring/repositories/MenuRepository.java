package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MenuRepository extends JpaRepository<Menu, LocalDate> {
}
