package com.patientcare.patient.model;

import java.sql.Date;
import java.util.List;

import com.patientcare.patient.entity.Drug;

public class HistoryResp {
	
	private Integer claimsid;
	private String status;
	private String opioidflag;
	private Date claimsdate;
	public List<Drug> druglist;
	
	public HistoryResp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setClaimsid(Integer claimsid) {
		this.claimsid = claimsid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOpioidflag(String opioidflag) {
		this.opioidflag = opioidflag;
	}

	public void setClaimsdate(Date claimsdate) {
		this.claimsdate = claimsdate;
	}

	public void setDruglist(List<Drug> druglist) {
		this.druglist = druglist;
	}

}
