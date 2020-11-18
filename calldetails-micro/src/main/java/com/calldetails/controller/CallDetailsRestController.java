package com.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.calldetails.dto.CallDetailsDto;
import com.calldetails.service.ICallDetailsService;

@RestController
public class CallDetailsRestController {
	@Autowired
	ICallDetailsService  service;
	
	@GetMapping("/{phoneNumber}")
	public  List<CallDetailsDto>  getCallDetailsByPhoneNumber(@PathVariable Long phoneNumber) {
		return  service.readCallDetails(phoneNumber);
	}

}
