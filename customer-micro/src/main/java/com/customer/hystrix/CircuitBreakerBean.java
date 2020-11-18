/**
 * 
 */
package com.customer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author siva
 *
 */
//@Component
public class CircuitBreakerBean {

	@Autowired
	@Qualifier("restTemplate2")
	private RestTemplate loadBalancedRestTemplate;

	private static String FRIEND_URL = "http://FRIENDMICRO/FriendApi/{phoneNumber}";

	@HystrixCommand(fallbackMethod = "getFriendContactFallBack")
	public List<Long> getFriendContact(Long phoneNumber) {
		ParameterizedTypeReference<List<Long>> typeRef = new ParameterizedTypeReference<List<Long>>() {
		};
		ResponseEntity<List<Long>> re = loadBalancedRestTemplate.exchange(FRIEND_URL, HttpMethod.GET, null, typeRef,
				phoneNumber);
		List<Long> friendsContactList = re.getBody();
		return friendsContactList;

	}

	public List<Long> getFriendContactFallBack(Long phoneNumber) {
		return new ArrayList<Long>();
	}

}
