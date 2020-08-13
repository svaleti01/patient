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

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getDrug() {
		return drug;
	}


	public void setDrug(String drug) {
		this.drug = drug;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public ClaimsRequest(String username, Date date, String drug, Integer count) {
		super();
		this.username = username;
		this.date = date;
		this.drug = drug;
		this.count = count;
	}

}
