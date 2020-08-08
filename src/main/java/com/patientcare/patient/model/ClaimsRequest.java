package com.patientcare.patient.model;

import java.sql.Date;

public class ClaimsRequest {
	
	private String username;
	private Date date;
	private DrugNCount[] drugs;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DrugNCount[] getDrugs() {
		return drugs;
	}
	public void setDrugs(DrugNCount[] drugs) {
		this.drugs = drugs;
	}
	

}
