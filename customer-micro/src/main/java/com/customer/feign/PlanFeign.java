/**
 * 
 */
package com.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.dto.PlanDTO;

/**
 * @author siva
 *
 */
@FeignClient("PLANMICRO")
public interface PlanFeign {
	
	@GetMapping("PlanApi/{planId}")
	PlanDTO getPlanDetails(@PathVariable String planId);

}
