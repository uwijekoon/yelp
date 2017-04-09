package com.ci6205.yelp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

	private String id;
	private String name;
	private Integer reviewCount;
	private Date yelpingSince;
	private Integer useful;
	private Integer funny;
	private Integer cool;
	private Integer fans;
	//Added by Divya
	private Integer numFriends;  
	private double averageStars;
	private Integer complimentHot;
	private Integer complimentMore;
	private Integer complimentProfile;
	private Integer complimentCute;
	private Integer complimentList;
	private Integer complimentNote;
	private Integer complimentPlain;
	private Integer complimentCool;
	private Integer complimentFunny;
	private Integer complimentWriter;
	private Integer complimentPhotos;
	private List<Integer> eliteYearList;
	private List<Review> reviewList;
	private List<Tip> tipList;
	private List<User> friendsList;
	private double locationX;
	private double locationY;

	public User() {
	}

	public User(String id) {
		this.id = id;
	}
	
	public User(String id, double locationX, double locationY){
		this.id = id;
		this.locationX = locationX;
		this.locationY = locationY;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Date getYelpingSince() {
		return yelpingSince;
	}

	public void setYelpingSince(Date yelpingSince) {
		this.yelpingSince = yelpingSince;
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

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Integer getFriendsCount() {
		return numFriends;
	}

	public void setFriendsCount(Integer numFriends) {
		this.numFriends = numFriends;
	}
	
	public Integer getComplimentHot() {
		return complimentHot;
	}

	public void setComplimentHot(Integer complimentHot) {
		this.complimentHot = complimentHot;
	}

	public Integer getComplimentMore() {
		return complimentMore;
	}

	public void setComplimentMore(Integer complimentMore) {
		this.complimentMore = complimentMore;
	}

	public Integer getComplimentProfile() {
		return complimentProfile;
	}

	public void setComplimentProfile(Integer complimentProfile) {
		this.complimentProfile = complimentProfile;
	}

	public Integer getComplimentCute() {
		return complimentCute;
	}

	public void setComplimentCute(Integer complimentCute) {
		this.complimentCute = complimentCute;
	}

	public Integer getComplimentList() {
		return complimentList;
	}

	public void setComplimentList(Integer complimentList) {
		this.complimentList = complimentList;
	}

	public Integer getComplimentNote() {
		return complimentNote;
	}

	public void setComplimentNote(Integer complimentNote) {
		this.complimentNote = complimentNote;
	}

	public Integer getComplimentPlain() {
		return complimentPlain;
	}

	public void setComplimentPlain(Integer complimentPlain) {
		this.complimentPlain = complimentPlain;
	}

	public Integer getComplimentCool() {
		return complimentCool;
	}

	public void setComplimentCool(Integer complimentCool) {
		this.complimentCool = complimentCool;
	}

	public Integer getComplimentFunny() {
		return complimentFunny;
	}

	public void setComplimentFunny(Integer complimentFunny) {
		this.complimentFunny = complimentFunny;
	}

	public Integer getComplimentWriter() {
		return complimentWriter;
	}

	public void setComplimentWriter(Integer complimentWriter) {
		this.complimentWriter = complimentWriter;
	}

	public Integer getComplimentPhotos() {
		return complimentPhotos;
	}

	public void setComplimentPhotos(Integer complimentPhotos) {
		this.complimentPhotos = complimentPhotos;
	}

	public double getAverageStars() {
		return averageStars;
	}

	public void setAverageStars(double averageStars) {
		this.averageStars = averageStars;
	}

	public List<Integer> getEliteYearList() {
		return eliteYearList;
	}

	public void setEliteYearList(List<Integer> eliteYearList) {
		this.eliteYearList = eliteYearList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<Tip> getTipList() {
		return tipList;
	}

	public void setTipList(List<Tip> tipList) {
		this.tipList = tipList;
	}

	public List<User> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<User> friendsList) {
		this.friendsList = friendsList;
	}

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

}
