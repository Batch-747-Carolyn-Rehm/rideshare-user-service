package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.FilterService;
import com.revature.services.UserService;

/**
 * Implements the different types of filters available including byBatch, byCity, byZipcode and byRecommendation (default)
 * 
 * @author Matthias Quintero & Michael Tsang
 * */

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private DistanceService ds;

	@Autowired
	private UserService us;
	
	/**
	 * @param batchId represents the batch id to filter by
	 * @param drivers represents the cumulative drivers that meet the filter criteria (no duplicates)
	 * @return cumulative drivers that were filtered further by batch
	 * */
	@Override
	public Set<User> filterByBatch(int batchId, Set<User> drivers) {
		for (User u : us.getActiveDrivers()) {
			if (u.getBatch().getBatchNumber() == batchId && u.isAcceptingRides()) {
				drivers.add(u);
			}
		}
		return drivers;
	}
	
	/**
	 * @param zip represents the zip code to filter by
	 * @param drivers represents the cumulative drivers that meet the filter criteria (no duplicates)
	 * @return cumulative drivers that were filtered further by zip code
	 * */
	@Override
	public Set<User> filterByZipCode(String zip, Set<User> drivers) {
		for (User u : us.getActiveDrivers()) {
			if (u.gethZip().equals(zip) && u.isAcceptingRides()) {
				drivers.add(u);
			}
		}
		return drivers;
	}
	
	/**
	 * @param city represents the city to filter by
	 * @param drivers represents the cumulative drivers that meet the filter criteria (no duplicates)
	 * @return cumulative drivers that were filtered further by city
	 * */
	@Override
	public Set<User> filterByCity(String city, Set<User> drivers) {
		for (User u : us.getActiveDrivers()) {
			if (u.gethCity().equals(city) && u.isAcceptingRides()) {
				drivers.add(u);
			}
		}
		return drivers;
	}
	
	/**
	 * @param address represents the address to filter by
	 * @param batchId represents the batch id to filter by
	 * @return cumulative drivers that were filtered by distance from rider and match the batch id
	 * */
	@Override
	public Set<User> filterByRecommendation(String address, int batchId) throws ApiException, InterruptedException, IOException {
		Set<User> drivers = new HashSet<User>();
		String[] origins = { address };
		List<String> destinationList = new ArrayList<String>();
		for (User u : us.getActiveDrivers()) {
			if (u.isAcceptingRides() && u.getBatch().getBatchNumber() == batchId) {
				String fullAddress = u.gethAddress() + ", " + u.gethCity() + ", " + u.gethState();
				destinationList.add(fullAddress);
			}
		}
		String[] destinations = new String[destinationList.size()];
		destinations = destinationList.toArray(destinations);
		for(User u : ds.distanceMatrix(origins, destinations)) {
			drivers.add(u);
		}
		return drivers;
	}

}
