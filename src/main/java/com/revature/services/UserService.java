package com.revature.services;

import java.io.IOException;
import java.util.List;

import com.google.maps.errors.ApiException;
import com.revature.beans.Filter;
import com.revature.beans.User;

public interface UserService {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public List<User> getUserByUsername(String username);
	public List<User> getUserByRole(boolean isDriver);
	public List<User> getUserByRoleAndLocation(boolean isDriver, String location);
	public User addUser(User user);
	public User updateUser(User user);
	public String deleteUserById(int id);
	public List<User> getActiveDrivers();
	public List<User> getFilterSortedDriver(Filter filters, String sortBy, String sortDirection);
}
