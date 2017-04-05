package com.ci6205.yelp.entity;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {
	private String id;
	private double stars;
	private Date reviewDate;
	private String text;
	private Integer useful;
	private Integer funny;
	private Integer cool;
	private User user;
	private Business business;

	public Review() {
	}

	public Review(String id) {
		this.id = id;
	}

	public Review(String id, Date reviewDate) {
		this.id = id;
		this.reviewDate = reviewDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUseful() {
		return useful;
	}

	public void setUseful(Integer useful) {
		this.useful = useful;
	}

	public Integer getFunny() {
		return funny;
	}

	public void setFunny(Integer funny) {
		this.funny = funny;
	}

	public Integer getCool() {
		return cool;
	}

	public void setCool(Integer cool) {
		this.cool = cool;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

}
