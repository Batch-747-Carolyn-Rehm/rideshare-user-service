package com.revature.beans;

import java.util.List;

/**
 * Used for filtering the driver list results
 * 
 * @author Matthias Quintero & Michael Tsang
 * */

public class Filter {
	private List<String> filterTypes;
	private int userId;
	private int batchId;
	
	public Filter() {
		super();
	}

	public Filter(List<String> filterTypes, int userId, int batchId) {
		super();
		this.filterTypes = filterTypes;
		this.userId = userId;
		this.batchId = batchId;
	}

	public List<String> getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(List<String> filterTypes) {
		this.filterTypes = filterTypes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((filterTypes == null) ? 0 : filterTypes.hashCode());
		result = prime * result + userId;
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
		Filter other = (Filter) obj;
		if (batchId != other.batchId)
			return false;
		if (filterTypes == null) {
			if (other.filterTypes != null)
				return false;
		} else if (!filterTypes.equals(other.filterTypes))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filter [filterTypes=" + filterTypes + ", userId=" + userId + ", batchId=" + batchId + "]";
	}
	
}
