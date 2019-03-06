package com.revature.assignforce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.service.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	TrainerService trainerService;

	// findAll
	@GetMapping
	public List<Trainer> getAll() {
		return trainerService.getAll();
	}

	// findOne
	@GetMapping(value = "{id}")
	public ResponseEntity<Trainer> getById(@PathVariable int id) {
		Optional<Trainer> t = trainerService.findById(id);
		if (!t.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(t.get(), HttpStatus.OK);
	}

	// findby email
	@GetMapping(value = "email/{email}")
	public ResponseEntity<Trainer> getByEmail(@PathVariable String email) {
		Optional<Trainer> t = trainerService.findByEmail(email);
		if (!t.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(t.get(), HttpStatus.OK);
	}

	// create
	@PostMapping
	public ResponseEntity<Trainer> add(@RequestBody Trainer t) {
		t = trainerService.create(t);
		if (t == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	// update
	@PutMapping("{id}")
	public ResponseEntity<Trainer> update(@RequestBody Trainer t) {
		t = trainerService.update(t);
		if (t == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	// delete
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Trainer> delete(@PathVariable int id) {
		if (trainerService.findById(id) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		trainerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
 	}
	
}
