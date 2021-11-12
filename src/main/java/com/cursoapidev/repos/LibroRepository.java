package com.cursoapidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoapidev.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro,Integer>{

}
