package com.revature.beans.geoCodingResponse;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressComponent implements Serializable {
	
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
