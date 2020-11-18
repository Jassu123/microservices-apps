package com.calldetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calldetails.entity.CallDetails;

@Repository
public interface CallDetailsRepository extends JpaRepository<CallDetails, Long> {
	
	List<CallDetails>   findByCalledBy(Long calledBy);
	
}
