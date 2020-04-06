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
