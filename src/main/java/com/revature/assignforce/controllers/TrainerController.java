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

/**
 * 
 * A controller for retrieving, creating, updating and deleting Trainer information
 *
 */
@RestController
public class TrainerController {

	@Autowired
	TrainerService trainerService;

	/**
	 * 
	 * @return		A List of All Trainers
	 */
	@GetMapping
	public List<Trainer> getAll() {
		return trainerService.getAll();
	}

	/**
	 * 
	 * @param 	id	A Trainer Id of object to be retrieved
	 * @return		A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<Trainer> getById(@PathVariable int id) {
		Optional<Trainer> t = trainerService.findById(id);
		if (!t.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(t.get(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	email	The email of the trainer object to be retrieved
	 * @return			A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "email/{email}")
	public ResponseEntity<Trainer> getByEmail(@PathVariable String email) {
		Optional<Trainer> t = trainerService.findByEmail(email);
		if (!t.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(t.get(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	skill_id	The skill_id of the trainer object to be retrieved
	 * @return				A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "skill/{skill_id}")
	public ResponseEntity<List<Trainer>> getBySkill (@PathVariable int skill_id) {
		List<Trainer> trainers = trainerService.findBySkills(skill_id);
		if (trainers == null || trainers.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	lastName	The lastName of the trainer object to be retrieved
	 * @return				A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "lastName/{lastName}")
	public ResponseEntity<List<Trainer>> getByLastName (@PathVariable String lastName) {
		List<Trainer> trainers = trainerService.findByLastName(lastName);
		if (trainers == null || trainers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	firstName	The firstName of the trainer object to be retrieved
	 * @param 	lastName	The lastName of the trainer object to be retrieved
	 * @return				A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "firstAndLast/{firstName}/{lastName}")
	public ResponseEntity<List<Trainer>> getByFirstAndLastName (@PathVariable String firstName,
														  @PathVariable String lastName) {
		List<Trainer> trainers = trainerService.findByFirstAndLastName(firstName, lastName);
		if (trainers == null || trainers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	firstName	The firstName of the trainer object to be retrieved
	 * @return				A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@GetMapping(value = "firstName/{firstName}")
	public ResponseEntity<List<Trainer>> getByFirstName (@PathVariable String firstName) {
		List<Trainer> trainers = trainerService.findByFirstName(firstName);
		if (trainers == null || trainers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * 
	 * @param 	t	A New Trainer object
	 * @return		A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<Trainer> add(@RequestBody Trainer t) {
		t = trainerService.create(t);
		if (t == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param 	t	An Edited Trainer object
	 * @return		A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@PutMapping("{id}")
	public ResponseEntity<Trainer> update(@RequestBody Trainer t) {
		t = trainerService.update(t);
		if (t == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param 	id	A Trainer Id of object to be deleted
	 * @return		A Trainer ResponseEntity
	 * @see		Trainer
	 * @see		ResponseEntity
	 */
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Trainer> delete(@PathVariable int id) {
		if (trainerService.findById(id) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		trainerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
 	}
	
}
