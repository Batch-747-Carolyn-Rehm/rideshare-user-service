package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	private List<User> drivers = null;

	@Override
	public List<User> filterByBatch(int batchId) {
		drivers = new ArrayList<>();
		for (User u : us.getActiveDrivers()) {
			if (u.getBatch().getBatchNumber() == batchId && u.isAcceptingRides()) {
				drivers.add(u);
			}
		}
		return drivers;
	}

	@Override
	public List<User> filterByZipCode(String zip) {
		drivers = new ArrayList<>();
		for (User u : us.getActiveDrivers()) {
			if (u.gethZip().equals(zip) && u.isAcceptingRides()) {

			}
		}
		return drivers;
	}

	@Override
	public List<User> filterByCity(String city) {
		drivers = new ArrayList<>();
		for (User u : us.getActiveDrivers()) {
			if (u.gethCity().equals(city) && u.isAcceptingRides()) {
				drivers.add(u);
			}
		}
		return drivers;
	}

	@Override
	public List<User> filterByRecommendation(String address, int batchId) throws ApiException, InterruptedException, IOException {
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
		return ds.distanceMatrix(origins, destinations);
	}

}
