package com.cursoapidev.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoapidev.entities.Usuario;
import com.cursoapidev.repos.UsuarioRepository;

@RestController
public class UsuarioRestController {
	@Autowired
	UsuarioRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRestController.class);
	
	@RequestMapping(value="/usuarios/", method=RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/usuarios/{id}", method=RequestMethod.GET)
	public Usuario getUsuario(@PathVariable("id") int id) {
		LOGGER.info("finding usuario by id:"+ id);
		return repository.getById(id);
	}
	
	@RequestMapping(value="/usuarios/", method=RequestMethod.POST)
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@RequestMapping(value="/usuarios/{id}", method=RequestMethod.DELETE)
	public void deleteUsuario(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
