package com.revature.services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;

/**
 * Defines the behavior of the Filter Service
 * 
 * @author Matthias Quintero & Michael Tsang
 * */

public interface FilterService {
	Set<User> filterByBatch(int batchId, Set<User> totalDrivers);
	Set<User> filterByZipCode(String zip, Set<User> totalDrivers);
	Set<User> filterByCity(String city, Set<User> totalDrivers);
	Set<User> filterByRecommendation(String address, int batchId) throws ApiException, InterruptedException, IOException;
}