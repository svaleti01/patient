package com.patientcare.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientcare.patient.entity.Drug;
import com.patientcare.patient.repo.DrugRepo;

@Service
public class DrugService {
	
	@Autowired
	public DrugRepo drugRepo;
	
	public DrugService(DrugRepo drugRepo) {
		this.drugRepo = drugRepo;
	}
	
	public List<Drug> getDrugByUserid(Integer userid) {
		return drugRepo.getByUserid(userid);
	}

	public void addDrug(Drug drug) {
		drugRepo.save(drug);
	}
}
