package com.cursoapidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoapidev.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
