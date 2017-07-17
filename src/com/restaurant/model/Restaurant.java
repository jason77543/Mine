package com.restaurant.model;

import java.io.Serializable;

public class Restaurant implements Serializable{
	private Integer restNo;
	private String restName;
	private String restAdd;
	private String restPhone;
	private String restIntro;
	private Integer restKind;
	private Integer restReviewStatus;
	private Float restLongtitude;
	private Float restLatitude;
	
	public Restaurant(Integer restNo, String restName, String restAdd, String restPhone, String restIntro,
			Integer restKind,  Integer restReviewStatus, Float restLongtitude, Float restLatitude) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.restAdd = restAdd;
		this.restPhone = restPhone;
		this.restIntro = restIntro;
		this.restKind = restKind;
		this.restReviewStatus = restReviewStatus;
		this.restLongtitude = restLongtitude;
		this.restLatitude = restLatitude;
	}

	public Integer getRestNo() {
		return restNo;
	}

	public void setRestNo(Integer restNo) {
		this.restNo = restNo;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestAdd() {
		return restAdd;
	}

	public void setRestAdd(String restAdd) {
		this.restAdd = restAdd;
	}

	public String getRestPhone() {
		return restPhone;
	}

	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone;
	}

	public String getRestIntro() {
		return restIntro;
	}

	public void setRestIntro(String restIntro) {
		this.restIntro = restIntro;
	}

	public Integer getRestKind() {
		return restKind;
	}

	public void setRestKind(Integer restKind) {
		this.restKind = restKind;
	}


	public Integer getRestReviewStatus() {
		return restReviewStatus;
	}

	public void setRestReviewStatus(Integer restReviewStatus) {
		this.restReviewStatus = restReviewStatus;
	}

	public Float getRestLongtitude() {
		return restLongtitude;
	}

	public void setRestLongtitude(Float restLongtitude) {
		this.restLongtitude = restLongtitude;
	}

	public Float getRestLatitude() {
		return restLatitude;
	}

	public void setRestLatitude(Float restLatitude) {
		this.restLatitude = restLatitude;
	}

	public Restaurant() {
		super();
	}
	
	
}
