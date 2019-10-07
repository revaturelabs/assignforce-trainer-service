package com.revature.assignforce.revaturepro;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;


/**
 * @author Dylan Boyce
 *
 *This Class is a prepared skeleton(no functionality) in anticipation for the integration of AssignForce into RevaturePro. 
 *The bellow methods are guidelines to help you identify the intended functionality we had in mind. Your batch may have a
 * shift in purpose by the time this project falls into your hands.
 *
 *The purpose of this class is to house methods for either retrieving and/or modifying information from the Revature Pro API.
 *Each method needs to handle both the communication with the Revature Pro API and the conversion of the data to 
 *AssignForce.
 *
 *Keep in mind that it is important that the information originating from RevPro needs to be identifiable as such and not
 *confused with information that is originating from within AssignForce. 
 */

public class TrainerRepo {

	/**
	 * The purpose of this method is to retrieve and return all trainer records from the RevaturePro API. It should send a GET request and convert
	 * the response into a Trainer object, preferably using Jackson or GSON.
	 *  
	 * @return This method returns a List of trainer objects.
	 */
	public List<Trainer> getAll(){
		return null;
	}
	
	/**
	 * The purpose of this method is to retrieve and return a specific trainer by its table id(not an employee or trainer id). It should send a GET 
	 * request and convert the response into a Trainer Object, preferably using Jackson or GSON. You should take advantage of the "Optional" type to
	 * check if a Trainer is actually found. The .isPresent() method will tell you if the object is null or not and the .get() method will actually return
	 * the value. (You can find an example on using Optional and its methods in the TrainerServiceImpl Class)
	 * 
	 * @param id : This Id is an auto generated Id for the purpose of the table. It is not an "employee" id of any sort. 
	 * @return This method returns the Trainer Object that corresponds to the given Id
	 */
	public Optional<Trainer> findById(int id){
		return null;
	}
	
	/**
	 * The purpose of this method is to retrieve and return a specific trainer by their email address. It should send a GET 
	 * request to the RevaturePro API and convert the response into a Trainer Object, preferably using Jackson or GSON. You 
	 * should take advantage of the "Optional" type to check if a Trainer is actually found. The isPresent() method will tell
	 * you if the object is null or not and the get() method will actually return the value. 
	 * (You can find an example on using Optional and its methods in the TrainerServiceImpl Class)
	 * 
	 * @param email 
	 * @return This method returns the Trainer Object that corresponds to the Trainers email address
	 */
	public Optional<Trainer> findByEmail(String email){
		return null;
	}
	
	/**
	 * 
	 *The purpose of this method is to update a Trainer in the Revature Pro database via a PUT request method to
	 *the Revature Pro API. This method should return the updated Trainer object. 
	 * 
	 * @param t : Takes in an already existing Trainer Object
	 * @return Returns the Updated Trainer Object
	 */
	public Trainer update(Trainer t) {
		return null;
	}
	
	/**
	 *The purpose of this method is to create a new Trainer in the Revature Pro database via a POST request method to 
	 *the Revature Pro API. This method should return the newly saved Trainer object. 
	 * 
	 * @param t
	 * @return
	 */
	public Trainer create(Trainer t) {
		//save a new Trainer with an Empty Hashset of skills 
		Set<SkillIdHolder> skills = t.getSkills();
		if (skills == null) {
			skills = new HashSet<>();
			t.setSkills(skills);
		}
		//return the new Trainer Object into the endpoint to insert a new trainer into RevPro
		return null;
	}
	
	/**
	 * The purpose of this method is to delete a trainer from the database utilizing a Delete http request to the RevaturePro API.
	 * @param id
	 */
	public void delete(int id) {
		//Keep in mind that Trainers have a relationship(dependency) with skills
		//Thus, Trainers cannot be Deleted without the skills being deleted first
		//refer to "TrainerServiceimpl for code on how they remedied deleting skills first, then deleting Trainer
		//this may not translate to the new API we are integrating into 
	}
	
	
	/**
	 * The purpose of this method is to retrieve and return a list of trainers by their preffered locations. It should send a GET 
	 * request to the RevaturePro API and convert the response into a list of Trainer Objects, preferably using Jackson or GSON.
	 * 
	 * @param preferredLocation
	 * @return A list of Trainers specific to location prefference
	 */
	public List<Trainer> findByPrefferedLocation(Integer preferredLocation){
		
		return null;
	}
	
	
	/**
	 * The purpose of this method is to retrieve and return a list of trainers who have a specific skill. It should send a GET 
	 * request to the RevaturePro API and convert the response into a list of Trainer Objects, preferably using Jackson or GSON. 
	 * 
	 * @param skill_id
	 * @return a List of Trainers who have the intended skill given as an argument
	 */
	public List<Trainer> findBySkills(int skill_id) {
		
		return null;
	}
	
	/**
	 * The purpose of this method is to retrieve and return a list of trainers by a given last name. It should send a GET 
	 * request to the RevaturePro API and convert the response into a list of Trainer Objects, preferably using Jackson or GSON. 
	 * 
	 * @param lastName
	 * @return List of Trainers
	 */
	public List<Trainer> findByLastName(String lastName) {
		
		return null;
	}

	/**
	 * The purpose of this method is to retrieve and return a list of trainers who share a first and last name. It should send a GET 
	 * request to the RevaturePro API and convert the response into a list of Trainer Objects, preferably using Jackson or GSON. 
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @return List of Trainers
	 */
	public List<Trainer> findByFirstAndLastName(String firstName, String lastName) {
		
		return null;
	}
	
	/**
	 * The purpose of this method is to retrieve and return a list of trainers by first name. It should send a GET 
	 * request to the RevaturePro API and convert the response into a list of Trainer Objects, preferably using Jackson or GSON. 
	 *  
	 * 
	 * @param firstName
	 * @return A list of trainers
	 */
	public List<Trainer> findByFirstName(String firstName) {
		
		return null;
	}
	
	
	
	
	
	
	
}
