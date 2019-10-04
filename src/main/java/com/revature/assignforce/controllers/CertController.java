package com.revature.assignforce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.service.CertService;

import io.swagger.annotations.Api;


/**
 * 
 * A controller for retrieving, creating, updating and deleting Certification information
 *
 */
@RestController
@RequestMapping("/certs")
@Api(value = "CertController", 
description = "REST APIs for retrieving, creating, updating and deleting Certification information")
public class CertController {

	@Autowired
	CertService service;

	/**
	 * 
	 * @return		A List of All Certifications
	 */
	@GetMapping
	public List<Cert> getAll() {
		return service.getAll();
	}

	/**
	 * 
	 * @param 	id	A Certification Id of object to be retrieved
	 * @return		A Certification ResponseEntity
	 * @see		Certification
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<Cert> getById(@PathVariable int id) {
		Optional<Cert> c = service.findById(id);
		if (!c.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(c.get(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param 	c	A New Certification object
	 * @return		A Certification ResponseEntity
	 * @see		Certification
	 * @see		ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<Cert> add(@RequestBody Cert c) {
		c = service.create(c);
		if (c == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param 	c	An Edited Certification object
	 * @return		A Certification ResponseEntity
	 * @see		Certification
	 * @see		ResponseEntity
	 */
	@PutMapping
	public ResponseEntity<Cert> update(@RequestBody Cert c) {
		c = service.update(c);
		if (c == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param 	id	A Certification Id of object to be deleted
	 * @return		A Certification ResponseEntity
	 * @see		Certification
	 * @see		ResponseEntity
	 */
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Cert> delete(@PathVariable int id) {
		if (service.findById(id) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
