package com.revature.beans.geoCodingResponse;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressComponent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String longName;
	private String shortName;
	private ArrayList<String> types;
	
	public AddressComponent() {
		super();
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	@JsonProperty("long_name")
	public String getLongName() {
		return longName;
	}

	@JsonProperty("long_name")
	public void setLongName(String longName) {
		this.longName = longName;
	}

	@JsonProperty("short_name")
	public String getShortName() {
		return shortName;
	}

	@JsonProperty("short_name")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
}
