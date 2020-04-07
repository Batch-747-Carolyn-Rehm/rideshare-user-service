package com.revature.services.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.FilterService;

/**
 * Used to filter driver results
 * 
 * @author Matthias Quintero & Michael Tsang
 * */
@Service
public class FilterServiceImpl implements FilterService {


	private Iterator<User> tempDrivers = null;
	
	/**
	 * @param batchId represents the user's batch number
	 * @param drivers represents the cumulative drivers
	 * @return a set of filtered cumulative drivers
	 * */
	@Override
	public Set<User> filterByBatch(int batchId, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = tempDrivers.next();
			if (u.getBatch().getBatchNumber() != batchId || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}
	
	/**
	 * @param zip represents the user's home address zip code
	 * @param drivers represents the cumulative drivers
	 * @return a set of filtered cumulative drivers
	 * */
	@Override
	public Set<User> filterByZipCode(String zip, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = tempDrivers.next();
			if (!u.gethZip().equals(zip) || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}
	
	/**
	 * @param city represents the user's home address city
	 * @param drivers represents the cumulative drivers
	 * @return a set of filtered cumulative drivers
	 * */
	@Override
	public Set<User> filterByCity(String city, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = tempDrivers.next();
			if (!u.gethCity().equals(city) || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}
	
	/**
	 * @param address represents the user's home address
	 * @param batchId represents the user's batch number
	 * @param totalDrivers represents the cumulative drivers
	 * @return a set of filtered cumulative drivers
	 * */
	@Override
	public Set<User> filterByRecommendation(String address, int batchId, Set<User> totalDrivers) throws ApiException, InterruptedException, IOException {
		tempDrivers = totalDrivers.iterator();
		while(tempDrivers.hasNext()) {
			User u = tempDrivers.next();
			if (!u.isActive() || u.getBatch().getBatchNumber() != batchId || u.getDistance() > 8046.72) {
				tempDrivers.remove();
			}
		}
		return totalDrivers;
	}

}
