package com.revature.services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;

public interface FilterService {
	Set<User> filterByBatch(int batchId, Set<User> totalDrivers);
	Set<User> filterByZipCode(String zip, Set<User> totalDrivers);
	Set<User> filterByCity(String city, Set<User> totalDrivers);
	Set<User> filterByRecommendation(String address, int batchId, Set<User> totalDrivers) throws ApiException, InterruptedException, IOException;
}
