package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDto;
import com.customer.dto.LoginDTO;
import com.customer.dto.PlanDTO;
import com.customer.dto.RegisterDTO;
import com.customer.feign.FriendFeign;
import com.customer.feign.PlanFeign;
import com.customer.service.ICustomerService;

@RestController
//@RibbonClient(name = "custribbon" )
public class CustomerRestController {
	private static String PLAN_URL = "http://PLANMICRO/PlanApi/{planId}";
	private static String FRIEND_URL = "http://FRIENDMICRO/FriendApi/{phoneNumber}";
	// private static String FRIEND_URL="http://localhost:4242/FriendApi/{phoneNumber}";

	@Autowired
	private ICustomerService service;
	@Autowired
	FriendFeign friendFeign;
	
	@Autowired
	PlanFeign planFeign;
	
	/*@Autowired
	private CircuitBreakerBean circuitBreakerBean;
	*/
	
	/*@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@Autowired
	@Qualifier("restTemplate2")
	private RestTemplate loadBalancedRestTemplate;
	
	*/

	@PostMapping("/register")
	public boolean addCustomer(@RequestBody RegisterDTO registerDto) {
		return service.registerCustomer(registerDto);
	}

	@PostMapping("/login")
	public boolean loginCustomer(@RequestBody LoginDTO loginDto) {
		return service.loginCustomer(loginDto);
	}

	@GetMapping("/viewProfile/{phoneNumber}")
	public CustomerDto customerProfile(@PathVariable Long phoneNumber) {
		CustomerDto customerDto = service.readCustomer(phoneNumber);

		// calling friend-microservice
	/*
		ParameterizedTypeReference<List<Long>> typeRef = new ParameterizedTypeReference<List<Long>>() {
		};
		ResponseEntity<List<Long>> re = loadBalancedRestTemplate.exchange(FRIEND_URL, HttpMethod.GET, null, typeRef, phoneNumber);
		List<Long> friendsContactList = re.getBody();
		*/
		
		/*List<Long> friendContactList=circuitBreakerBean.getFriendContact(customerDto.getPhoneNumber());
		customerDto.setFriendsContactNumbers(friendContactList);

		// calling plan-microservice
		PlanDTO planDto = loadBalancedRestTemplate.getForObject(PLAN_URL, PlanDTO.class, customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);
		*/

		List<Long> friendContactList=friendFeign.getFriends(customerDto.getPhoneNumber());
		customerDto.setFriendsContactNumbers(friendContactList);
		PlanDTO planDto= planFeign.getPlanDetails(customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);
		
		return customerDto;

	}
}
