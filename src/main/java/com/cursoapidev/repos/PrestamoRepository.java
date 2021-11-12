package com.cursoapidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoapidev.entities.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {

}
