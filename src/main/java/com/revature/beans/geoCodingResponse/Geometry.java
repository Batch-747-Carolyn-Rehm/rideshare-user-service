package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	private String locationType;
	private Viewport viewport;
	
	public Geometry() {
		super();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	@JsonProperty("location_type")
	public String getLocationType() {
		return locationType;
	}

	@JsonProperty("location_type")
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

}
