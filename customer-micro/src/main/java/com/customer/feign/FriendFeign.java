/**
 * 
 */
package com.customer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author siva
 *
 */

@FeignClient("FRIENDMICRO")
public interface FriendFeign {
	
	@GetMapping("FriendApi/{phoneNumber}")
	List<Long> getFriends(@PathVariable Long phoneNumber);

}
