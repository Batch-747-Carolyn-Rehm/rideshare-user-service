package com.revature.beans.geolocationResponse;

import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {

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
