package com.plan.service;

import java.util.List;

import com.plan.dto.PlanDTO;

public interface IPlanService {
	
	List<PlanDTO>  getAllPlans();
	
	PlanDTO   getSpecificPlan(String planId);

}
