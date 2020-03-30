package com.revature.beans.geoCodingResponse;

import java.io.Serializable;

public class Plus_code implements Serializable {
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

