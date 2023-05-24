package com.financefolio.user;

import com.financefolio.social.FriendsList;

public class Member extends User {
	private boolean premiumMember;
	private int category;
	private float income;
	private int houseArea;
	private int houseResidents;
	private FriendsList friends;
	
	public void updateHouseDetails(int area, int residents) {
		this.setHouseArea(area);
		this.setHouseResidents(residents);
	}
	
	public int getHouseResidents() {
		return houseResidents;
	}
	public void setHouseResidents(int houseResidents) {
		this.houseResidents = houseResidents;
	}
	public int getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(int houseArea) {
		this.houseArea = houseArea;
	}
	public float getIncome() {
		return income;
	}
	public void updateIncome(float income) {
		this.income = income;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public boolean isPremiumMember() {
		return premiumMember;
	}
	public void updateMembership(boolean membership) {
		this.premiumMember = membership;
	}

	public FriendsList getFriends() {
		return friends;
	}

	
	
}
