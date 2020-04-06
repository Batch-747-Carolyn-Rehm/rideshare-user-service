package com.revature.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.UserService;
/**
 * DistanceServiceImpl handles any additional services that need to be made before calling the
 * repository methods.
 * 
 * @author documentation by Faysal Anis
 *
 */

@Service
public class DistanceServiceImpl implements DistanceService {
	
	@Autowired
	private UserService us;

	/**
	 * Calculates distances between the current user and a list of drivers, adding those distances
	 * to the drivers
	 * 
	 * @param originUser represents the user which all distances are based from
	 * @param driverList represents the list of users we will calculate distances from originUser to
	 * @exception IOException On input error.
	 * @exception ApiException on incorrect Google Maps integration
	 * @exception InterruptedException when the thread is interrupted
	 */
	@Override
	public void getDistances(User originUser, List<User> driverList)
			throws ApiException, InterruptedException, IOException {
		System.out.println(driverList);
		String fullAddress = originUser.gethAddress() + ", " + originUser.gethCity() + ", " + originUser.gethState();
		String[] origins = {fullAddress};
		
		List<String> destinationList = new ArrayList<String>();
		
		for(User d : driverList) {
			
			String add = d.gethAddress();
			String city = d.gethCity();
			String state = d.gethState();
			
			String fullAdd = add + ", " + city + ", " + state;
			
			destinationList.add(fullAdd);
						
		}
		
		String[] destinations = new String[destinationList.size()];
		destinations = destinationList.toArray(destinations);
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey(getGoogleMAPKey()).build();
		List<Double> arrlist = new ArrayList<Double>();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
		DistanceMatrix t = req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).units(Unit.IMPERIAL)
				.await();
		
		for (int j = 0; j < destinations.length; j++) {
			try {
				System.out.println((j+1) + "): " + t.rows[0].elements[j].distance.inMeters + " meters");
				driverList.get(j).setDistance(((double) t.rows[0].elements[j].distance.inMeters));
				driverList.get(j).setDuration((double) t.rows[0].elements[j].duration.inSeconds);
				
				System.out.println((double) t.rows[0].elements[j].distance.inMeters);
				
			} catch (Exception e) {
//				e.printStackTrace();
			System.out.println("invalid address");
			}
		}
		
	}
	
	/**
	 * Gets the Google Map Key to present onto the API map
	 * 
	 * @return null is returned after completion
	 */
	public String getGoogleMAPKey() {
        Map<String, String> env = System.getenv();
        for (Map.Entry <String, String> entry: env.entrySet()) {
            if(entry.getKey().equals("googleMapAPIKey")) {
                return entry.getValue();
            }
        }
        return null;
    }
	
	
	

}