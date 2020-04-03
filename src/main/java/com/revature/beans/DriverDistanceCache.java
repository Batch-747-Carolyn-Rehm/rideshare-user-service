package com.revature.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DriverDistanceCache {
	
	private Map<Integer, List<User>> driverDistanceCache;

	public DriverDistanceCache() {
		super();
		driverDistanceCache = new HashMap<>();
	}
	

	public Map<Integer, List<User>> getDriverDistanceCache() {
		return new HashMap<>(driverDistanceCache);
	}



	public void setDriverDistanceCache(Map<Integer, List<User>> driverDistanceCache) {
		this.driverDistanceCache = driverDistanceCache;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverDistanceCache == null) ? 0 : driverDistanceCache.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverDistanceCache other = (DriverDistanceCache) obj;
		if (driverDistanceCache == null) {
			if (other.driverDistanceCache != null)
				return false;
		} else if (!driverDistanceCache.equals(other.driverDistanceCache))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DriverDistanceCache [driverDistanceCache=" + driverDistanceCache + "]";
	}
	

}
