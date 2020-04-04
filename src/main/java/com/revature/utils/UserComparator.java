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
	
	public static Comparator<User> getComparator(String sortBy, String sortDirection) {
		Comparator<User> comparator = null;
		boolean isAsc = sortDirection.equalsIgnoreCase("asc") || !sortDirection.equalsIgnoreCase("desc");
		
		switch(sortBy) {
		case "name":
			comparator = Comparator.comparing(User::getFirstName);
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
