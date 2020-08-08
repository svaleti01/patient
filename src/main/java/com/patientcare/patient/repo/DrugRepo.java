package com.patientcare.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patientcare.patient.entity.Drug;

@Repository
public interface DrugRepo extends JpaRepository<Drug, Integer> {
	
	@Query("select d from Drug d where d.userid = :userid")
	public List<Drug> getByUserid(@Param("userid") Integer userid);

}
