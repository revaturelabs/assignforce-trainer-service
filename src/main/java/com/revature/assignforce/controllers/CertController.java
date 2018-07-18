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

@RestController
@RequestMapping("/certs")
public class CertController {

	@Autowired
	CertService service;

	@GetMapping
	public List<Cert> getAll() {
		return service.getAll();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Cert> getById(@PathVariable int id) {
		Optional<Cert> c = service.findById(id);
		if (!c.isPresent())
			return new ResponseEntity<Cert>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cert>(c.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cert> add(@RequestBody Cert c) {
		c = service.create(c);
		if (c == null)
			return new ResponseEntity<Cert>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Cert>(c, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cert> update(@RequestBody Cert c) {
		c = service.update(c);
		if (c == null)
			return new ResponseEntity<Cert>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Cert>(c, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Cert> delete(@PathVariable int id) {
		service.delete(id);
		return new ResponseEntity<Cert>(HttpStatus.OK);
	}
}
