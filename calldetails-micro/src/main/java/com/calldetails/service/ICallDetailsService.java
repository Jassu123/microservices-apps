package com.calldetails.service;

import java.util.List;

import com.calldetails.dto.CallDetailsDto;

public interface ICallDetailsService {
	List<CallDetailsDto>  readCallDetails(Long  phoneNumber);

}
