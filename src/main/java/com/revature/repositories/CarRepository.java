package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Car;

/**
 * CarRepository which extends the JpaRepository.
 * This repository handles our various queries.
 * 
 * @author Adonis Cabreja
 *
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {	
	
	/**
	 * Custom query that uses the @Query annotation to select a car by 
	 * car_id asspciated with user.
	 * 
	 * @param userId represents the user's id.
	 * @return Check {@link com.revature.services.impl.UserServiceImpl}
	 */
	@Query("select car from User u where u.userId = ?1")
	public Car getCarByUserId(int userId);
}
