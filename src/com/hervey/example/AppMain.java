package com.hervey.example;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.hervey.example.Person;

public class AppMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(AppMain.class.getName());
		
		List<Person> persons =  new ArrayList<Person>();


		//For example, suppose that we have to write a loop that sends emails for a list of persons. The code (in Java) could look like this:
		for (Person person: persons) {
			if(person.getEmailAddress() !=null) {
				//code to send email
				System.out.println("code to send email executed");
			}
			else {
				logger.warning("No email address for " + person.getName());
				
			}
		}
		
		
		

	}

}
