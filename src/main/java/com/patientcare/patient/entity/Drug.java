package com.patientcare.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="drug")
public class Drug {
	
	@Id
	@Column(name="drugid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer drugid;
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="claimsid")
	private Integer claimsid;
	
	@Column(name="drugname")
	private String drugname;
	
	@Column(name="count")
	private Integer count;

	public Integer getDrugid() {
		return drugid;
	}

	public void setDrugid(Integer drugid) {
		this.drugid = drugid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getClaimsid() {
		return claimsid;
	}

	public void setClaimsid(Integer claimsid) {
		this.claimsid = claimsid;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Drug(Integer userid, Integer claimsid, String drugname, Integer count) {
		super();
		this.userid = userid;
		this.claimsid = claimsid;
		this.drugname = drugname;
		this.count = count;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
