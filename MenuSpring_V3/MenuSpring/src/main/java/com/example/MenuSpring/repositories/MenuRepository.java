package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuId(Long id);
    @Query("SELECT m FROM Menu m WHERE m.date= :date")
    List<Menu> findMenuToday(LocalDate date);

}
