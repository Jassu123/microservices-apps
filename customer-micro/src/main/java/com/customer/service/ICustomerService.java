package com.customer.service;

import com.customer.dto.CustomerDto;
import com.customer.dto.LoginDTO;
import com.customer.dto.RegisterDTO;

public interface ICustomerService {
	boolean  registerCustomer(RegisterDTO  registerDto);
	boolean  loginCustomer(LoginDTO  loginDto);
	CustomerDto  readCustomer(Long phoneNumber);
}
