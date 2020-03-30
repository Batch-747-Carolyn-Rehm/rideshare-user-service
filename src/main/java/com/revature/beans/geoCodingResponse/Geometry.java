package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

public class Geometry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	private String location_type;
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

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

}
