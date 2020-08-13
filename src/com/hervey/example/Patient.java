package com.hervey.example;

import java.util.ArrayList;
import java.util.List;



public class Patient {
	
		static List<Patient> allPatients = new ArrayList<Patient>();
		
		public static Patient getPatientbyId(String patientId) {
			//System.out.println("patient ID passed into this method is:  " + patientId);
			//System.out.println("allPatients the List is:  " + allPatients);
		for (Patient patient : allPatients) {
			if (patient.getPatientId() == patientId) {
				//System.out.println("we found this patient:  " + patient);
				return patient;
			}
		}
		return null;

	}
	

		
		
		

	
	
	public Patient() {
		allPatients.add(this);
		
	}
	
	String patientId;
	
	String patientName;
	
	List<Allergy> allergiesOfPatient = new ArrayList<Allergy>();
	
//	public void addToAllergyListOfPatient(Allergy allergy) {
//		System.out.println("allergy is:  " + allergy);
//		System.out.println("current list of allergies:  " + allergiesOfPatient);
//		allergiesOfPatient.add(allergy);
//		
//		//this.allergiesOfPatient.add(allergy);
//	}

	public List<String> getNamesOfAllergiesOfPatient() {
		List<String> listOfAllergyNamesPatient = new ArrayList<String>();
		for (Allergy allergy : this.allergiesOfPatient) {
			listOfAllergyNamesPatient.add(allergy.getAllergeyName());	
		}
		return listOfAllergyNamesPatient;
	}
	
	
	public List<Allergy> getAllergiesOfPatient() {
		return this.allergiesOfPatient;
	}

	public void setAllergiesOfPatient(List<Allergy> allergiesOfPatient) {
		this.allergiesOfPatient = allergiesOfPatient;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public List<Patient> getAllPatients() {
		return allPatients;
	}

	public void setAllPatients(List<Patient> allPatients) {
		this.allPatients = allPatients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allPatients == null) ? 0 : allPatients.hashCode());
		result = prime * result + ((allergiesOfPatient == null) ? 0 : allergiesOfPatient.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
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
		Patient other = (Patient) obj;
		if (allPatients == null) {
			if (other.allPatients != null)
				return false;
		} else if (!allPatients.equals(other.allPatients))
			return false;
		if (allergiesOfPatient == null) {
			if (other.allergiesOfPatient != null)
				return false;
		} else if (!allergiesOfPatient.equals(other.allergiesOfPatient))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", allergiesOfPatient="
				+ allergiesOfPatient + "]";
	}










	
	
	
	

}
