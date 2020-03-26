package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class GeoLocationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Result> results;
	private String status;
	
	public GeoLocationResponse() {
		super();
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoLocationResponse other = (GeoLocationResponse) obj;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeoLocationResponse [results=" + results + ", status=" + status + "]";
	}
	
}

class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<AddressComponent> address_components;
	private String formatted_address;
	private Geometry geometry;
	private String place_id;
	private Plus_code plus_code;
	private ArrayList<String> types;
	
	public Result() {
		super();
	}

	public ArrayList<AddressComponent> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(ArrayList<AddressComponent> address_components) {
		this.address_components = address_components;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public Plus_code getPlus_code() {
		return plus_code;
	}

	public void setPlus_code(Plus_code plus_code) {
		this.plus_code = plus_code;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	
}

class AddressComponent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String long_name;
	private String short_name;
	private ArrayList<String> types;
	
	public AddressComponent() {
		super();
	}

	public String getLong_name() {
		return long_name;
	}

	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	
}

class Geometry implements Serializable {
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

class Plus_code implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String compound_code;
	private String global_code;
	public Plus_code() {
		super();
	}
	public String getCompound_code() {
		return compound_code;
	}
	public void setCompound_code(String compound_code) {
		this.compound_code = compound_code;
	}
	public String getGlobal_code() {
		return global_code;
	}
	public void setGlobal_code(String global_code) {
		this.global_code = global_code;
	}
	
}

class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lat;
	private String lng;
	public Location() {
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

class Viewport implements Serializable {
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

class Northeast implements Serializable {
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

class Southwest implements Serializable {
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


