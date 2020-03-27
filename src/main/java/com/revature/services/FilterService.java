package com.revature.services;

import java.io.IOException;
import java.util.List;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;

public interface FilterService {
	List<User> filterByBatch(int batchId);
	List<User> filterByZipCode(String zip);
	List<User> filterByCity(String city);
	List<User> filterByRecommendation(String address, int batchId) throws ApiException, InterruptedException, IOException;
}
