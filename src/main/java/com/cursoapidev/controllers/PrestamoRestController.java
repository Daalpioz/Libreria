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

import com.cursoapidev.entities.Prestamo;
import com.cursoapidev.repos.PrestamoRepository;

@RestController
public class PrestamoRestController {
	@Autowired
	PrestamoRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestamoRestController.class);
	
	@RequestMapping(value="/prestamos/", method=RequestMethod.GET)
	public List<Prestamo> getPrestamos(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/prestamos/{id}", method=RequestMethod.GET)
	public Prestamo getPrestamo(@PathVariable("id") int id) {
		LOGGER.info("finding prestamo by id:"+ id);
		return repository.getById(id);
	}
	
	@RequestMapping(value="/prestamos/", method=RequestMethod.POST)
	public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
		return repository.save(prestamo);
	}
	
	@RequestMapping(value="/prestamos/{id}", method=RequestMethod.DELETE)
	public void deletePrestamo(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
