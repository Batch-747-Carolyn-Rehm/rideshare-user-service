package com.revature.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.User;
import com.revature.beans.geoCodingResponse.GeoCodingReponse;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		String address = "";
		String[] splittedHAddress = user.gethAddress().split(" ");
		String joinedHAddress = String.join("+", splittedHAddress);
		if (user.getwAddress() != null) {
			String[] splittedWAddress = user.getwAddress().split(" ");
			String joinedWAddress = String.join("+", splittedWAddress);
			address = joinedHAddress + "+" + joinedWAddress + "+" + user.gethCity() + "+" + user.gethState() + "+" + user.gethZip();
		} else {
			address = joinedHAddress + "+" + user.gethCity() + "+" + user.gethState() + "+" + user.gethZip();
		}
		
		String apiKey = System.getenv("googleMapAPIKey");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;
		GeoCodingReponse gr = restTemplate.getForObject(url, GeoCodingReponse.class);
		
		if (gr.getResults().size() == 0 || gr.getResults().size() > 1 || gr.getResults().size() == 1 && gr.getResults().get(0).isPartialMatch() == true) {
			errors.rejectValue("hZip", "Invalid");
			errors.rejectValue("hCity", "Invalid");
			errors.rejectValue("hAddress", "Invalid");
			errors.rejectValue("wAddress", "Invalid");
			errors.rejectValue("hState", "Invalid");	
		} 
	}

	
}
