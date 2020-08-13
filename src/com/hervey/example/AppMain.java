package com.hervey.example;

//created this simple project as follow-along to Christian Neumanns's article on null

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.hervey.example.Person;

public class AppMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(AppMain.class.getName());

		/// The Person/email address example

		List<Person> persons = new ArrayList<Person>();
		Person Alice = new Person();
		Alice.setName("Alice");
		Alice.setEmailAddress("alice@alice.com"); // Added to suppress warning

		persons.add(Alice);

		// For example, suppose that we have to write a loop that sends emails for a
		// list of persons. The code (in Java) could look like this:
		for (Person person : persons) {
			if (person.getEmailAddress() != null) {
				// code to send email
				System.out.println("code to send email executed");
			} else {
				logger.warning("No email address for " + person.getName());

			}
		}
		// end Person/email address example

		Patient patientFred = new Patient();

		patientFred.setPatientId("123");
		patientFred.setPatientName("Fred");

		Patient patientLisa = new Patient();

		patientLisa.setPatientId("456");
		patientLisa.setPatientName("Lisa");

		Allergy allergyA = new Allergy("allergyA-name");
		// System.out.println("name of allergyA is: " + allergyA);
		Allergy allergyB = new Allergy("allergyB-name");

		// patientLisa.addToAllergyListOfPatient(allergyA);

		List<Allergy> listOfSomeAllergies;
		listOfSomeAllergies = null;
		listOfSomeAllergies = new ArrayList<Allergy>();
		// listOfSomeAllergies.add(allergyA); //commented out to meet the empty condition described in the article as: Does it mean...
		// listOfSomeAllergies.add(allergyB); //commented out to meet the empty condition described in the article as: Does it mean...

		patientLisa.setAllergiesOfPatient(listOfSomeAllergies);

		System.out.println("The allergies of patient with id of 456 (Lisa) are " + getAllergiesOfPatientById("456"));
		System.out.println("The allergy names of patient with id of 456 (Lisa) are " + getAllergiesNamesOfPatientById("456"));
		// System.out.println("The allergies of patient with id of 123 are " + getAllergiesOfPatientById("123"));
		System.out.println("The allergies of patient with id of 456, interface " + getAllergiesOfPatientByIdUsingInterface("456"));
		

	}

	static List<Allergy> getAllergiesOfPatientById(String patientId) {
		Patient patient = Patient.getPatientbyId(patientId);
		// System.out.print("This patient has name of: " + patient.getPatientName());
		// System.out.println(" and the patient has allergies of " +
		// patient.getAllergiesOfPatient());
		return patient.getAllergiesOfPatient();
	}

	static List<String> getAllergiesNamesOfPatientById(String patientId) {
		Patient patient = Patient.getPatientbyId(patientId);
		// System.out.print("This patient has name of: " + patient.getPatientName());
		// System.out.println(" and the patient has allergies of " +
		// patient.getAllergiesOfPatient());
		return patient.getNamesOfAllergiesOfPatient();
	}

	// Alternative below produces null result on empty allergies
	static List<String> getAllergiesNamesOfPatientByIdwithNull(String patientId) {
		Patient patient = Patient.getPatientbyId(patientId);
		if (patient.getNamesOfAllergiesOfPatient().size() < 1) {
			return null;
		}
		return patient.getNamesOfAllergiesOfPatient();
	}

	// solution uses interfaces
	
	public static AllergyTestResult getAllergiesOfPatientByInterface(String patientId) {
		Patient patient = Patient.getPatientbyId(patientId);
		//Demo case of not done
		AllergyTestResult allergyTestResult = new AllergyMaker(patient.getAllergiesOfPatient());
		
		return allergyTestResult;

	}

	static AllergyTestResult getAllergiesOfPatientByIdUsingInterface(String patientId) {
		AllergyTestResult allergyTestResult = getAllergiesOfPatientByInterface("123");
		if (allergyTestResult instanceof NotDoneAllergyTestResult) {
			System.out.println("Test not done yet");
		} else if (allergyTestResult instanceof PendingAllergyTestResult) {
			System.out.println("Test pending");
		} else if (allergyTestResult instanceof DoneAllergyTestResult) {
			List<Allergy> list = ((DoneAllergyTestResult) allergyTestResult).getAllergies();
			if (list == null) {
				System.out.println("No allergies");
			} else if (list.isEmpty()) {
				assert false;
			} else {
				System.out.println("There are allergies");
			}
		} else {
			assert false;
		}

		return null;

	}



}
