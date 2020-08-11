package com.patientcare.patient;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patientcare.patient.controller.UserController;
import com.patientcare.patient.model.ClaimsRequest;

@SpringBootTest
class PatientApplicationTests {
	
	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllUsersTest() {
		userController.getAllUsers("user1");
	}
	
	@Test
	public void claimsRequestTest() {
		// create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();

		// now, create a java.sql.Date from the java.util.Date
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		ClaimsRequest claimsRequest = new ClaimsRequest("user1", date, "anacin", 10);
		userController.claimsRequest(claimsRequest);
	}

}
