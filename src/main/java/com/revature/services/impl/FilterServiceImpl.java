package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.FilterService;
import com.revature.services.UserService;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private DistanceService ds;

	@Autowired
	private UserService us;
	
	private Iterator<User> tempDrivers = null;

	@Override
	public Set<User> filterByBatch(int batchId, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = (User) tempDrivers.next();
			if (u.getBatch().getBatchNumber() != batchId || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByZipCode(String zip, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = (User) tempDrivers.next();
			if (!u.gethZip().equals(zip) || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByCity(String city, Set<User> drivers) {
		tempDrivers = drivers.iterator();
		while (tempDrivers.hasNext()) {
			User u = (User) tempDrivers.next();
			if (!u.gethCity().equals(city) || !u.isActive()) {
				tempDrivers.remove();
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByRecommendation(String address, int batchId, Set<User> totalDrivers)
			throws ApiException, InterruptedException, IOException {
//		Set<User> drivers = new HashSet<User>();
//		String[] origins = { address };
//		System.out.println(address);
//		System.out.println(batchId);
//		List<String> destinationList = new ArrayList<String>();
//		for (User u : us.getActiveDrivers()) {
//			if (u.isActive() && u.getBatch().getBatchNumber() == batchId) {
//				String fullAddress = u.gethAddress() + ", " + u.gethCity() + ", " + u.gethState();
//				destinationList.add(fullAddress);
////				System.out.println(fullAddress);
//			}
//		}
//		String[] destinations = new String[destinationList.size()];
//		destinations = destinationList.toArray(destinations);
//		System.out.println(destinations.length);
		for (User u : totalDrivers) {
//			System.out.println(u);
			if (!u.isActive() || u.getBatch().getBatchNumber() != batchId) {
				totalDrivers.remove(u);
			}
		}
		return totalDrivers;
	}

}
