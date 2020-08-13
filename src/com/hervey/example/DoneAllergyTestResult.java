package com.hervey.example;

import java.util.Date;
import java.util.List;

public interface DoneAllergyTestResult extends AllergyTestResult {
	public Date getDateDone();
	
	public List<Allergy> getAllergies(); //null if no allergies //non-empty if there are allergies

}
