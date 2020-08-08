package com.patientcare.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patientcare.patient.entity.Claims;

@Repository
public interface ClaimsRepo extends JpaRepository<Claims, Integer> {

	@Query("select c from Claims c where c.userid = :userid")
	public List<Claims> getByUserid(@Param("userid") Integer userid);

}
