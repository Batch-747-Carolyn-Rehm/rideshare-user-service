package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.BatchService;
import com.revature.services.DistanceService;
import com.revature.services.FilterService;
import com.revature.services.UserService;
import com.revature.validators.UserValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * UserController takes care of handling our requests to /users.
 * It provides methods that can perform tasks like all users, user by role (true or false), user by username,
 * user by role and location, add user, update user and delete user by id. 
 * 
 * @author Adonis Cabreja
 *
 */

@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(tags= {"User"})
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private BatchService bs;
	
	@Autowired
	private DistanceService ds;
	
	@Autowired
	private UserValidator uv;

	@Autowired
	private FilterService fs;
	
	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and users by is-driver and location.
	 */
	
	
	/*@ApiOperation(value="Returns user drivers", tags= {"User"})
	@GetMapping
	public List<User> getActiveDrivers() {
		return us.getActiveDrivers();
	}*/
	
	
	@ApiOperation(value="Returns user drivers", tags= {"User"})
	@GetMapping("/driver/{address}")
	public List <User> getTopFiveDrivers(@PathVariable("address")String address) throws ApiException, InterruptedException, IOException {
		//List<User> aps =  new ArrayList<User>();
		System.out.println(address);
		List<String> destinationList = new ArrayList<String>();
		String [] origins = {address};
//		
	    Map<String, User> topfive = new HashMap<String, User>();
//		
		for(User d : us.getActiveDrivers()) {
//			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
//			
			topfive.put(fullAdd, d);
//						
	}
//		
//		System.out.println(destinationList);
//		
		String [] destinations = new String[destinationList.size()];
////		
	destinations = destinationList.toArray(destinations);
//		
	return	ds.distanceMatrix(origins, destinations);
//		
//		
		//return ds.distanceMatrix();	
		
	}
	
	//Get Drivers by different filters
	
	@ApiOperation(value="Returns drivers by filter",tags= {"User"})
	@GetMapping("/filter/{filter_type}")
	public List<User> getFilteredDrivers(@PathVariable("filter_type") String filter_type,
			@RequestBody User u) throws ApiException, InterruptedException, IOException{
		List<User> drivers = new ArrayList<User>();
		switch(filter_type) {
		//TODO: get current location in request body
		case "batch":{
			drivers = fs.filterByBatch(u.getBatch().getBatchNumber());
			break;
		}
		case "zipcode":{
			drivers = fs.filterByZipCode(u.gethZip());
			break;
		}
		case "city":{
			drivers = fs.filterByCity(u.gethCity());
			break;
		}
		default:{
			//TODO: add people in UTA to the H2 db
			drivers = fs.filterByRecommendation(u.gethAddress(), 
					u.getBatch().getBatchNumber());
			break;
		}
		}
		return drivers;
	}
	
	
	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and users by is-driver and location.
	 */
	
	@ApiOperation(value="Returns all users", tags= {"User"}, notes="Can also filter by is-driver, location and username")
	@GetMapping
	public List<User> getUsers(@RequestParam(name="is-driver",required=false)Boolean isDriver,
							   @RequestParam(name="username",required=false)String username,
							   @RequestParam(name="location", required=false)String location) {
		
		if (isDriver != null && location != null) {
			return us.getUserByRoleAndLocation(isDriver.booleanValue(), location);
		} else if (isDriver != null) {
			return us.getUserByRole(isDriver.booleanValue());
		} else if (username != null) {
			return us.getUserByUsername(username);
		}
		
		return us.getUsers();
	}
	
	/**
	 * HTTP GET (users/{id})
	 * 
	 * @param id represents the user's id.
	 * @return A user that matches the id.
	 */
	
	@ApiOperation(value="Returns user by id", tags= {"User"})
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")int id) {
		
		return us.getUserById(id);
	}
	
	/**
	 * HTTP POST method (/users)
	 * 
	 * @param user represents the new User object being sent.
	 * @return The newly created object with a 201 code.
	 * 
	 * Sends custom error messages when incorrect input is used
	 */
	
	@ApiOperation(value="Adds a new user", tags= {"User"})
	@PostMapping
	public ResponseEntity<Map> addUser(@Valid @RequestBody User user, BindingResult result) {
		
		uv.validate(user, result);
		
		Map<String, String> validationInfo = new HashMap<>();
		for (FieldError error: result.getFieldErrors()) {
			validationInfo.put(error.getField(), error.getCode());
		}
		
		if (validationInfo.size() == 0) {
			user.setBatch(bs.getBatchByNumber(user.getBatch().getBatchNumber()));
	 		us.addUser(user);
		}
		
		return new ResponseEntity<>(validationInfo, HttpStatus.OK);
		
	}
	
	/**
	 * HTTP PUT method (/users)
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	
	@ApiOperation(value="Updates user by id", tags= {"User"})
	@PutMapping
	public ResponseEntity<Map> updateUser(@Valid @RequestBody User user, BindingResult result) {
		//validating address using custom validator
		uv.validate(user, result);
		System.out.println("validation result is " + result);
		
		Map<String, String> validationInfo = new HashMap<>();
		for (FieldError error: result.getFieldErrors()) {
			validationInfo.put(error.getField(), error.getCode());
		}
		
		if (validationInfo.size() == 0) {
			us.updateUser(user);
		}
		
		return new ResponseEntity<>(validationInfo, HttpStatus.OK);
	}
	
	/**
	 * HTTP DELETE method (/users)
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	
	@ApiOperation(value="Deletes user by id", tags= {"User"})
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id")int id) {
		
		return us.deleteUserById(id);
	}
	
	
}
