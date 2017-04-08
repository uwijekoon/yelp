package com.ci6205.yelp.entity;

import java.io.Serializable;
import java.util.Date;

public class Tip implements Serializable {

	private Integer id;
	private String tipText;
	private Date tipDate;
	private Integer likes;
	private String tipType;
	private Business business;
	private User user;

	public Tip() {
	}

	public Tip(Integer id) {
		this.id = id;
	}

	public Tip(Integer id, String tipText, Date tipDate, String tipType) {
		this.id = id;
		this.tipText = tipText;
		this.tipDate = tipDate;
		this.tipType = tipType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipText() {
		return tipText;
	}

	public void setTipText(String tipText) {
		this.tipText = tipText;
	}

	public Date getTipDate() {
		return tipDate;
	}

	public void setTipDate(Date tipDate) {
		this.tipDate = tipDate;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getTipType() {
		return tipType;
	}

	public void setTipType(String tipType) {
		this.tipType = tipType;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
