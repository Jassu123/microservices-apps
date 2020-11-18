package com.friend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.entity.Friend;
import com.friend.repository.FriendRepository;
import com.friend.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService {
	@Autowired
	FriendRepository  repository;

	@Override
	public String addFriendService(Friend friend) {
		Integer  count=repository.checkFriendContact(friend.getPhoneNumber(), friend.getFriendNumber());
		if(count==0) {
			repository.saveAndFlush(friend);
			return  "Friend contact is added";
		}
		else {
			return "Friend contact already exist";
		}
	}

	@Override
	public List<Long> readFriendsContacts(Long phoneNumber) {
		return  repository.findFriendsContactNumbers(phoneNumber);
	}

}
