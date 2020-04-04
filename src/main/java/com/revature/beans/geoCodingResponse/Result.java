package com.revature.beans.geoCodingResponse;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<AddressComponent> addressComponents;
	private String formattedAddress;
	private Geometry geometry;
	private String placeId;
	private PlusCode plusCode;
	private ArrayList<String> types;
	private boolean partialMatch;
	
	@JsonProperty("partial_match")
	public boolean isPartialMatch() {
		return partialMatch;
	}

	@JsonProperty("partial_match")
	public void setPartialMatch(boolean partialMatch) {
		this.partialMatch = partialMatch;
	}

	public Result() {
		super();
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	@JsonProperty("plus_code")
	public PlusCode getPlusCode() {
		return plusCode;
	}

	@JsonProperty("plus_code")
	public void setPlusCode(PlusCode plusCode) {
		this.plusCode = plusCode;
	}

	@JsonProperty("address_components")
	public ArrayList<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	@JsonProperty("address_components")
	public void setAddressComponents(ArrayList<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}

	@JsonProperty("formatted_address")
	public String getFormattedAddress() {
		return formattedAddress;
	}

	@JsonProperty("formatted_address")
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	@JsonProperty("place_id")
	public String getPlaceId() {
		return placeId;
	}

	@JsonProperty("place_id")
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	
}
