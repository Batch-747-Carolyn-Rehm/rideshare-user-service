package com.revature.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Car;
import com.revature.beans.User;
import com.revature.services.CarService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper om;
	
	@MockBean
	private CarService cs;
		
	@Test
	public void testGettingCars() throws Exception {
		
		List<Car> cars = new ArrayList<>();
		cars.add(new Car());
		cars.add(new Car());
		when(cs.getCars()).thenReturn(cars);
		
		mvc.perform(get("/cars"))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void testGettingCarById() throws Exception {
		
		Car car = new Car(1, "red", 4, "Honda", "Accord", 2015);
		when(cs.getCarById(1)).thenReturn(car);
		
		mvc.perform(get("/cars/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.carId").value(1));
	}
	
	@Test
	public void testGettingCarByUserId() throws Exception {
		
		Car car = new Car(1, "red", 4, "Honda", "Accord", 2015);
		when(cs.getCarByUserId(1)).thenReturn(car);
		
		mvc.perform(get("/cars/users/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.carId").value(1));
	}
	
	@Test
	public void testAddingCar() throws Exception {
				
		Car car = new Car(1, "red", 4, "Honda", "Accord", 2015);
		when(cs.addCar(new Car(1, "red", 4, "Honda", "Accord", 2015))).thenReturn(car);
		
		mvc.perform(post("/cars").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(car)))
		   .andExpect(status().isCreated());
	}
	
	@Test
	public void testAddingBadCar() throws Exception {
				
		Car car = new Car();
		when(cs.addCar(car)).thenReturn(car);
		
		mvc.perform(post("/cars").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(car)))
		   .andExpect(status().isBadRequest());
	}
		
	@Test
	public void testUpdatingCar() throws Exception {
		
		Car car = new Car(1, "red", 4, "Honda", "Accord", 2015);
		when(cs.updateCar(new Car(1, "red", 4, "Honda", "Accord", 2015))).thenReturn(true);
	
		mvc.perform(put("/cars/", 1).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(car)))
		   .andExpect(status().isOk());
	}
	
	@Test
	public void testUpdatingBadCar() throws Exception {
		
		Car car = new Car();
		when(cs.updateCar(car)).thenReturn(true);
	
		mvc.perform(put("/cars/", 1).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(car)))
		   .andExpect(status().isBadRequest());
	}
	
	@Test
	public void testDeletingCar() throws Exception {
		
		Car car = new Car(1, "red", 4, "Honda", "Accord", 2015);
		String returnedStr = "Car with id: " + car.getCarId() + " was deleted";
		when(cs.deleteCarById(1)).thenReturn(returnedStr);
		
		mvc.perform(delete("/cars/{id}", 1))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$").value(returnedStr));
	}
}
