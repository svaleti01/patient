package com.patientcare.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientcare.patient.entity.Claims;
import com.patientcare.patient.repo.ClaimsRepo;

@Service
public class ClaimsService {
	
	@Autowired
	public ClaimsRepo claimsRepo;
	
	public ClaimsService(ClaimsRepo claimsRepo) {
		this.claimsRepo = claimsRepo;
	}
	
	public List<Claims> getClaimsByUserid(Integer userid) {
		return claimsRepo.getByUserid(userid);
	}
	
	public Integer addClaims(Claims claims) {
		claimsRepo.save(claims);
		return claims.getClaimsid();
	}

}
