package com.patientcare.patient.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="claims")
public class Claims {
	
	@Id
	@Column(name="claimsid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer claimsid;
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="opioidflag")
	private String opioidflag;
	
	@Column(name="claimsdate")
	private Date claimsdate;

	@Column(name="userscore")
	private Integer userscore;
	
	public Integer getClaimsid() {
		return claimsid;
	}

	public void setClaimsid(Integer claimsid) {
		this.claimsid = claimsid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpioidflag() {
		return opioidflag;
	}

	public void setOpioidflag(String opioidflag) {
		this.opioidflag = opioidflag;
	}

	public Date getClaimsdate() {
		return claimsdate;
	}

	public void setClaimsdate(Date claimsdate) {
		this.claimsdate = claimsdate;
	}

	public Integer getUserscore() {
		return userscore;
	}

	public void setUserscore(Integer userscore) {
		this.userscore = userscore;
	}	

	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claims(Integer userid, String status, String opioidflag, Date claimsdate, Integer userscore) {
		super();
		this.userid = userid;
		this.status = status;
		this.opioidflag = opioidflag;
		this.claimsdate = claimsdate;
		this.userscore = userscore;
	}

}
