package com.revature.beans.geolocationResponse;

import java.io.Serializable;

public class Southwest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lat;
	private String lng;
	public Southwest() {
		super();
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
}