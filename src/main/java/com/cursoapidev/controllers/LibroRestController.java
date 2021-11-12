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

import com.cursoapidev.entities.Libro;
import com.cursoapidev.repos.LibroRepository;

@RestController
public class LibroRestController {
	@Autowired
	LibroRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LibroRestController.class);
	
	@RequestMapping(value="/libros/", method=RequestMethod.GET)
	public List<Libro> getLibros(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/libros/{id}", method=RequestMethod.GET)
	public Libro getLibro(@PathVariable("id") int id) {
		LOGGER.info("finding libro by id:"+ id);
		return repository.getById(id);
	}
	
	@RequestMapping(value="/libros/", method=RequestMethod.POST)
	public Libro createLibro(@RequestBody Libro libro) {
		return repository.save(libro);
	}
	
	@RequestMapping(value="/libros/{id}", method=RequestMethod.DELETE)
	public void deleteLibro(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
