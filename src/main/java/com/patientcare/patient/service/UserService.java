package com.patientcare.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientcare.patient.entity.User;
import com.patientcare.patient.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	public UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public User getUserByUsername(String username) {
		return userRepo.getByUsername(username);
	}
	
}
