package com.dnd.quancuatui.model;

import java.util.ArrayList;

public class DetailRestaurant {
	int detailID;
	int districtID;
	int categoryID;
	String title;
	String address;
	String time;
	String price;
	double longitude;
	double latitude;
	String detailInfo;
	String advantage;
	String disadvantage;
	float rate;
	String[] list_image_links;
	int numberLike;
	int numberShare;
	String avatar_link;

	public int getDetailID() {
		return detailID;
	}

	public void setDetailID(int detailID) {
		this.detailID = detailID;
	}

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getDisadvantage() {
		return disadvantage;
	}

	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	

	public int getNumberLike() {
		return numberLike;
	}

	public void setNumberLike(int numberLike) {
		this.numberLike = numberLike;
	}

	public int getNumberShare() {
		return numberShare;
	}

	public void setNumberShare(int numberShare) {
		this.numberShare = numberShare;
	}

	public String getAvatar_link() {
		return avatar_link;
	}

	public void setAvatar_link(String avatar_link) {
		this.avatar_link = avatar_link;
	}

	public String[] getList_image_links() {
		return list_image_links;
	}

	public void setList_image_links(String[] list_image_links) {
		this.list_image_links = list_image_links;
	}

}
