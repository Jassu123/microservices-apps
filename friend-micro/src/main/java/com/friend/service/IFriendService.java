package com.friend.service;

import java.util.List;

import com.friend.entity.Friend;

public interface IFriendService {
	String  addFriendService(Friend friend);
	List<Long>  readFriendsContacts(Long phoneNumber);

}
