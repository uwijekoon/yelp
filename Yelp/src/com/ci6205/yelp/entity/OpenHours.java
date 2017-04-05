package com.ci6205.yelp.entity;

import java.io.Serializable;

public class OpenHours implements Serializable {

	private Integer id;
	private String day;
	private String fromTime;
	private String toTime;
	private Business businessId;

	public OpenHours() {
	}

	public OpenHours(Integer id) {
		this.id = id;
	}

	public OpenHours(Integer id, String day, String fromTime, String toTime) {
		this.id = id;
		this.day = day;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Business getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}

}
