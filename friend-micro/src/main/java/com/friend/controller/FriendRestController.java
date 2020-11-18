package com.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friend.entity.Friend;
import com.friend.service.IFriendService;

@RestController
public class FriendRestController {
	
	@Autowired
	IFriendService  service;
	
	@PostMapping("/addFriend")
	public  String   addFriend(@RequestBody  Friend  friend) {
		return  service.addFriendService(friend);
	}
	
	@GetMapping("/{phoneNumber}")
	public  List<Long>  getFriendsContacts(@PathVariable Long phoneNumber){
		
		return  service.readFriendsContacts(phoneNumber);
	}
	

}
