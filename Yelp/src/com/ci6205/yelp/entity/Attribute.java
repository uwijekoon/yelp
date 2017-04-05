package com.ci6205.yelp.entity;

import java.io.Serializable;

public class Attribute implements Serializable {
	private Integer id;
	private String attributeName;
	private String subCategory;
	private String attributeValue;
	private Business businessId;

	public Attribute() {
	}

	public Attribute(Integer id) {
		this.id = id;
	}

	public Attribute(Integer id, String attributeValue) {
		this.id = id;
		this.attributeValue = attributeValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Business getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}

}
