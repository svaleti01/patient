package com.patientcare.patient.model;

import java.sql.Date;

public class ClaimsRequest {
	
	private String username;
	private Date date;
	private String drug;
	private Integer count;
	public String getUsername() {
		return username;
	}
	public String getDrug() {
		return drug;
	}
	public Integer getCount() {
		return count;
	}

	public ClaimsRequest(String username, Date date, String drug, Integer count) {
		super();
		this.username = username;
		this.date = date;
		this.drug = drug;
		this.count = count;
	}

}
