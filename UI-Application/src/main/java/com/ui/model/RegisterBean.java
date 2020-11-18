package com.ui.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBean {
	@NotNull
	private   Long  phoneNumber;
	
	@NotEmpty
	private  String username;
	
	@NotEmpty
	@Size(min=8, max=20)
	private  String  password;
	
	@NotEmpty
	@Email
	private  String  email;
	
	@NotEmpty
	private  String  planId;
	
	private  List<PlanDTO>  plansList;
	
	
	
	
	public List<PlanDTO> getPlansList() {
		return plansList;
	}
	public void setPlansList(List<PlanDTO> plansList) {
		this.plansList = plansList;
	}
	
	
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	
	
	

}
