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

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private DistanceService ds;

	@Autowired
	private UserService us;

	@Override
	public Set<User> filterByBatch(int batchId, Set<User> drivers) {
		for (User u : drivers) {
			if (u.getBatch().getBatchNumber() != batchId || !u.isActive()) {
				drivers.remove(u);
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByZipCode(String zip, Set<User> drivers) {
		for (User u : drivers) {
			if (!u.gethZip().equals(zip) || !u.isActive()) {
				drivers.remove(u);
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByCity(String city, Set<User> drivers) {
		for (User u : drivers) {
			if (!u.gethCity().equals(city) || !u.isActive()) {
				drivers.remove(u);
			}
		}
		return drivers;
	}

	@Override
	public Set<User> filterByRecommendation(String address, int batchId, Set<User> totalDrivers) throws ApiException, InterruptedException, IOException {
		for(User u : totalDrivers) {
			if (!u.isActive() || u.getBatch().getBatchNumber() != batchId) {
				totalDrivers.remove(u);
			}
		}
		return totalDrivers;
	}

}
