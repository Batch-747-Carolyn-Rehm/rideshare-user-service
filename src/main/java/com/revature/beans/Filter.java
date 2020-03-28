package com.revature.beans;

import java.util.List;

public class Filter {
	private List<String> filterTypes;
	private String location;
	private int batchId;
	
	public Filter() {
		super();
	}

	public Filter(List<String> filterTypes, String location, int batchId) {
		super();
		this.filterTypes = filterTypes;
		this.location = location;
		this.batchId = batchId;
	}

	public List<String> getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(List<String> filterTypes) {
		this.filterTypes = filterTypes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Filter [filterTypes=" + filterTypes + ", location=" + location + ", batchId=" + batchId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((filterTypes == null) ? 0 : filterTypes.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
}
