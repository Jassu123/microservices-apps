package com.friend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer  id;
	
	@Column(name="PHONE_NO")
	private  Long  phoneNumber;
	
	@Column(name="FRIEND_NO")
	private  Long  friendNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getFriendNumber() {
		return friendNumber;
	}

	public void setFriendNumber(Long friendNumber) {
		this.friendNumber = friendNumber;
	}
	
	

}
