package com.revature.assignforce.revaturepro;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Cert;

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

public class CertRepo {

	/**
	 * The purpose of this method is to retrieve and return all certification records from the RevaturePro API. It should send a GET
	 *  request and convert the response into a list of Cert objects, preferably using Jackson or GSON.
	 * 
	 * @return a list of all Cert Objects
	 */
	public List<Cert> getAll() {
		return null;
	}

	/**
	 * The purpose of this method is to retrieve and return a specific Certification by its table id. It should send a GET 
	 * request and convert the response into a Cert Object, preferably using Jackson or GSON. You should take advantage of the
	 * "Optional" type to check if a Cert is actually found. The .isPresent() method will tell you if the object is null or not
	 * and the .get() method will actually return the value. (You can find an example on using Optional and its methods in the TrainerServiceImpl Class)
	 * 
	 * @param id
	 * @return a Cert Object
	 */
	public Optional<Cert> findById(int id) {
		return null;
	}

	/**
	 * 
	 *The purpose of this method is to update a certification in the Revature Pro database via a PUT request method to t
	 *the Revature Pro API. This method should return the updated Cert object. 
	 * 
	 * @param c : Takes in an already existing Cert Object
	 * @return Returns the Updated Cert Object
	 */
	public Cert update(Cert c) {
		return null;
	}

	/**
	 * The purpose of this method is to create a new certification in the Revature Pro database via a POST request method to 
	 *the Revature Pro API. This method should return the newly saved Cert object. 
	 * 
	 * @param c
	 * @return
	 */
	public Cert create(Cert c) {
		return null;
	}

	/**
	 * The purpose of this method is to delete a certification from the database utilizing a Delete http request to the RevaturePro API.
	 * 
	 * @param id
	 */
	public void delete(int id) {
		//endpoint.deleteById(id);
	}
	
	
	
}
