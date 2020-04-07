package com.revature.utils;

import java.io.Serializable;
import java.util.Comparator;

import com.revature.beans.User;

public class UserComparator implements Comparator<User>, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	* Get the comparator for the User class
	*
	* @param sortBy represents the filter criteria
	* @param isAsc represents the direction to sort the results
	* @return a comparator that compares User objects by the sortBy in order of ascending or reversed.
	*/
	public static Comparator<User> getComparator(String sortBy, boolean isAsc) {
		Comparator<User> comparator = null;

		switch(sortBy) {
			case "userId":
				comparator = Comparator.comparing(User::getUserId);
				break;
			case "name":
				comparator = Comparator.comparing(User::getFirstName);
				break;
			case "duration":
				comparator = Comparator.comparing(User::getDuration);
				break;
			case "seats":
				comparator = Comparator.comparing(User::getCar, (c1, c2) -> {
					return c1.getSeatsAvailable() - c2.getSeatsAvailable();
				});
				break;
			default:
				comparator = Comparator.comparing(User::getDistance);
		}
		
		if(!isAsc) {
			return comparator.reversed();
		} else {
			return comparator;
		}
	}
}
