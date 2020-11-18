package com.calldetails.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CallDetails {
	@Id
	private  Long  callId;
	
	private  Long  calledBy;
	
	private  Long  calledTo;
	
	@Temporal(TemporalType.DATE)
	private  Date  calledOn;
	
	private  Long  durationInSeconds;
	
	public Long getCallId() {
		return callId;
	}
	public void setCallId(Long callId) {
		this.callId = callId;
	}
	public Long getCalledBy() {
		return calledBy;
	}
	public void setCalledBy(Long calledBy) {
		this.calledBy = calledBy;
	}
	public Long getCalledTo() {
		return calledTo;
	}
	public void setCalledTo(Long calledTo) {
		this.calledTo = calledTo;
	}
	public Date getCalledOn() {
		return calledOn;
	}
	public void setCalledOn(Date calledOn) {
		this.calledOn = calledOn;
	}
	public Long getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(Long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

}
