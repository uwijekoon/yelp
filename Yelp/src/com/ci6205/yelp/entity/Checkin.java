package com.ci6205.yelp.entity;

import java.io.Serializable;

public class Checkin implements Serializable {

	private String count;
	private String time;
	private Business business;

	public Checkin() {
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}



}
