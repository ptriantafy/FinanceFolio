package com.financefolio.user;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.social.Friend;
import com.financefolio.social.FriendsList;

public class Member extends User {
	private boolean premiumMember;
	private int category;
	private float income;
	private int houseArea;
	private int houseResidents;
	private FriendsList friends;

	public Member(int id, String name, boolean premiumMember, int category, float income, int houseArea,
			int houseResidents) {
		super(id, name);
		this.premiumMember = premiumMember;
		this.category = category;
		this.income = income;
		this.houseArea = houseArea;
		this.houseResidents = houseResidents;
		this.friends = new FriendsList();
	}

	public void updateHouseDetails(int area, int residents) {
		this.setHouseArea(area);
		this.setHouseResidents(residents);
	}
	
	public boolean isPremiumMember() {
		return premiumMember;
	}
	public void updateMembership(boolean membership) {
		this.premiumMember = membership;
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
}
