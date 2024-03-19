package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.Poke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeRepository extends JpaRepository<Poke, Long> {
}
