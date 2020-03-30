package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

public class Viewport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Northeast northeast;
	private Southwest southwest;
	public Viewport() {
		super();
	}
	public Northeast getNortheast() {
		return northeast;
	}
	public void setNortheast(Northeast northeast) {
		this.northeast = northeast;
	}
	public Southwest getSouthwest() {
		return southwest;
	}
	public void setSouthwest(Southwest southwest) {
		this.southwest = southwest;
	}
	
}

