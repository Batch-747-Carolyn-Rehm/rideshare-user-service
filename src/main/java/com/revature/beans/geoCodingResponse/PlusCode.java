package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlusCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String compoundCode;
	private String globalCode;
	public PlusCode() {
		super();
	}

	@JsonProperty("compound_code")
	public String getCompoundCode() {
		return compoundCode;
	}
	@JsonProperty("compound_code")
	public void setCompoundCode(String compoundCode) {
		this.compoundCode = compoundCode;
	}

	@JsonProperty("global_code")
	public String getGlobalCode() {
		return globalCode;
	}

	@JsonProperty("global_code")
	public void setGlobalCode(String globalCode) {
		this.globalCode = globalCode;
	}
	
}

