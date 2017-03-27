package com.ci6205.yelp.entity;

import java.util.List;

public class Business {

	private String id;
	private String name;
	private String neighbourhood;
	private String address;
	private String city;
	private String businessState;
	private String postalCode;
	private double latitude;
	private double longitude;
	private double stars;
	private Integer reviewCount;
	private Character isOpen;
	private String businessType;
	private List<Checkin> checkins;
	private List<Review> reviews;
	private List<Tip> tips;
	private List<Attribute> attributeList;
	private List<String> categoryList;
	private List<OpenHours> openHours;

	public Business() {
	}

	public Business(String id) {
		this.id = id;
	}

	public Business(String id, String name, String businessState, String businessType) {
		this.id = id;
		this.name = name;
		this.businessState = businessState;
		this.businessType = businessType;
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

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBusinessState() {
		return businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Character getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Character isOpen) {
		this.isOpen = isOpen;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public List<Checkin> getCheckins() {
		return checkins;
	}

	public void setCheckins(List<Checkin> checkins) {
		this.checkins = checkins;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

	public List<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public List<OpenHours> getOpenHours() {
		return openHours;
	}

	public void setOpenHours(List<OpenHours> openHours) {
		this.openHours = openHours;
	}


}
