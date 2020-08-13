package com.hervey.example;

import java.util.ArrayList;
import java.util.List;

public class Allergy {

	
	public Allergy(String allergyName) {
		this.allergeyName = allergyName;
	}

	String allergeyName;
	
	String allergyType;

	public String getAllergeyName() {
		return allergeyName;
	}

	public void setAllergeyName(String allergeyName) {
		this.allergeyName = allergeyName;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergeyName == null) ? 0 : allergeyName.hashCode());
		result = prime * result + ((allergyType == null) ? 0 : allergyType.hashCode());
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
		Allergy other = (Allergy) obj;
		if (allergeyName == null) {
			if (other.allergeyName != null)
				return false;
		} else if (!allergeyName.equals(other.allergeyName))
			return false;
		if (allergyType == null) {
			if (other.allergyType != null)
				return false;
		} else if (!allergyType.equals(other.allergyType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Allergy [allergeyName=" + allergeyName + ", allergyType=" + allergyType + "]";
	}
	
	


}
