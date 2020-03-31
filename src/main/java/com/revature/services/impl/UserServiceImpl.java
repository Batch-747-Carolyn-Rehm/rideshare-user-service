package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.errors.ApiException;
import com.revature.beans.Filter;
import com.revature.beans.User;
import com.revature.repositories.UserRepository;
import com.revature.services.DistanceService;
import com.revature.services.FilterService;
import com.revature.services.UserService;
import com.revature.utils.UserComparator;

/**
 * UserServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author Adonis Cabreja
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private DistanceService ds;
	
	@Autowired
	private FilterService fs;
	
	@Override
	public List<User> getActiveDrivers() {
		return ur.getActiveDrivers();
	}
	
	/**
	 * Calls UserRepository's findAll method found in the JpaRepository.
	 * 
	 * @return A list of all the users.
	 */
	
	@Override
	public List<User> getUsers() {
		
		return ur.findAll();
	}

	/**
	 * Calls UserRepository's getOne method found in the JpaRepository.
	 * 
	 * @param id represents the user's id.
	 * @return A user that matches the id.
	 */
	
	@Override
	public User getUserById(int id) {
		return ur.findById(id).get();
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByUsername.
	 * 
	 * @param username represents the user's username.
	 * @return A user that matches the username.
	 */
	
	@Override
	public List<User> getUserByUsername(String username) {
		return ur.getUserByUsername(username);
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByRole.
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @return A list of users by role.
	 */
	
	@Override
	public List<User> getUserByRole(boolean isDriver) {
		return ur.getUserByRole(isDriver);
	}
	
	/**
	 * Calls UserRepository's custom query method getUserByRoleAndLocation.
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param location represents the batch location.
	 * @return A list of users by isDriver and location.
	 */
	
	@Override
	public List<User> getUserByRoleAndLocation(boolean isDriver, String location) {
		return ur.getUserByRoleAndLocation(isDriver, location);
	}
	
	/**
	 * Calls UserRepository's save method found in the JpaRepository.
	 * 
	 * @param user represents the new User object being sent.
	 * @return The newly created object.
	 */
	
	@Override
	public User addUser(User user) {
		return ur.save(user);
	}

	/**
	 * Calls UserRepository's save method found in the JpaRepository.
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	
	@Override
	public User updateUser(User user) {
		return ur.save(user);
	}

	/**
	 * Calls UserRepository's deleteById method found in the JpaRepository.
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	
	@Override
	public String deleteUserById(int id) {
		ur.deleteById(id);
		return "User with id: " + id + " was deleted.";
	}

	@Override
	public List<User> getFilterSortedDriver(Filter filters, String sortBy, String sortDirection) {
		
		Set<User> totalDrivers = new HashSet<User>();
		User currentUser = getUserById(filters.getUserId());
		//recommendation filter if no input filters are provided
		if(filters.getFilterTypes().size() == 0) {
			String fullAddress = currentUser.gethAddress() + ", " + currentUser.gethCity() + ", " + currentUser.gethState();
			try {
				totalDrivers = fs.filterByRecommendation(fullAddress, filters.getBatchId());
			} catch (ApiException | InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		//add drivers based on filter criteria
		else {
			for(String filter : filters.getFilterTypes()) {
				//drivers are calculated based on their home address (current location)
				switch(filter) {
				case "batch":{
					totalDrivers = fs.filterByBatch(filters.getBatchId(), totalDrivers);
					break;
				}
				case "zipcode":{
					totalDrivers = fs.filterByZipCode(currentUser.gethZip(), totalDrivers);
					break;
				}
				case "city":{
					totalDrivers = fs.filterByCity(currentUser.gethCity(), totalDrivers);
					break;
				}
				}
			}
		}
		
		return totalDrivers.stream()
				.sorted(UserComparator.getComparator(sortBy, sortDirection))
				.collect(Collectors.toList());
	}

}
