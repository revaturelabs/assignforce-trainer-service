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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * A controller for retrieving, creating, updating and deleting Trainer information
 *
 */
@RestController
@Api(value = "CertController")
public class TrainerController {

	@Autowired
	TrainerService trainerService;

	/**
	 * 
	 * @return		A List of All Trainers
	 */
	@GetMapping
	@ApiOperation(value = "Get All Trainers", 
	response = Trainer.class, responseContainer="List", 
	tags = "TrainerController", nickname= "getAllTrainers")
	public List<Trainer> getAll() {
		return trainerService.getAll();
	}

	/**
	 * 
	 * @param 	id	A Trainer Id of object to be retrieved
	 * @return		A Trainer ResponseEntity
	 * @see		Trainer
	 *
	 */
	@GetMapping(value = "{id}")
	@ApiOperation(value = "Get Trainer Information by Id", 
	response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "getTrainerById")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", response = Trainer.class)}) 
	public ResponseEntity<Trainer> getById(@ApiParam(name = "id") @PathVariable int id) {
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
	 *
	 */
	@GetMapping(value = "email/{email}")
	@ApiOperation(value = "Get Trainer Information by Email", 
	response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "getTrainerByEmail")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", 
            response = Trainer.class)}) 
	public ResponseEntity<Trainer> getByEmail(@ApiParam(name = "email") @PathVariable String email) {
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
	 *
	 */
	@GetMapping(value = "skill/{skill_id}")
	@ApiOperation(value = "Get All Trainers with given Skill Id",  
	tags = "TrainerController", nickname= "getTrainersBySkillId")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK",
            response = Trainer.class, responseContainer="List")}) 
	public ResponseEntity<List<Trainer>> getBySkill (@ApiParam(name = "skill_id") @PathVariable int skill_id) {
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
	 *
	 */
	@GetMapping(value = "lastName/{lastName}")
	@ApiOperation(value = "Get All Trainers with a given Lastname", 
	tags = "TrainerController", nickname= "getTrainersByLastname")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", 
            response = Trainer.class, responseContainer="List")}) 
	public ResponseEntity<List<Trainer>> getByLastName (@ApiParam(name = "lastName") @PathVariable String lastName) {
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
	 *
	 */
	@GetMapping(value = "firstAndLast/{firstName}/{lastName}")
	@ApiOperation(value = "Get All Trainers with given Firstname and Lastname",
	tags = "TrainerController", nickname= "getTrainersByFirstnameAndLastname")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", 
            response = Trainer.class, responseContainer="List")}) 
	public ResponseEntity<List<Trainer>> getByFirstAndLastName (@ApiParam(name = "firstName") @PathVariable String firstName,
			@ApiParam(name = "lastName") @PathVariable String lastName) {
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
	 *
	 */
	@GetMapping(value = "firstName/{firstName}")
	@ApiOperation(value = "Get All Trainers with a given Firstname", 
	//response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "getTrainersByFirstname")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", 
            response = Trainer.class, responseContainer="List")}) 
	public ResponseEntity<List<Trainer>> getByFirstName (@ApiParam(name = "firstName") @PathVariable String firstName) {
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
	 *
	 */
	@PostMapping
	@ApiOperation(value = "Create New Trainer Information", 
	response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "addTrainer")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad Request"), 
            @ApiResponse(code = 201, message = "Created", response = Trainer.class)})
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
	 *
	 */
	//@PutMapping("{id}")
	@ApiOperation(value = "Update Trainer Information", 
	response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "updateTrainer")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad Request"), 
            @ApiResponse(code = 201, message = "Created", response = Trainer.class)}) 
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
	 *
	 */
	@DeleteMapping(value = "{id}")
	@ApiOperation(value = "Delete Trainer Information", 
	response = ResponseEntity.class, 
	tags = "TrainerController", nickname= "deleteTrainer")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 200, message = "OK", response = Trainer.class)}) 
	public ResponseEntity<Trainer> delete(@ApiParam(name = "id") @PathVariable int id) {
		if (trainerService.findById(id) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		trainerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
 	}
	
}
