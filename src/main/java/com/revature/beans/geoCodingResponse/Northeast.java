package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

public class Northeast implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lat;
	private String lng;
	public Northeast() {
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