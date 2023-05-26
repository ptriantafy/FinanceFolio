package com.financefolio.user;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.social.Friend;
import com.financefolio.social.FriendRequest;
import com.financefolio.social.FriendRequestsList;
import com.financefolio.social.FriendsList;

public class Member extends User {
	private boolean premiumMember;
	private int category;
	private float income;
	private int houseArea;
	private int houseResidents;
	private FriendsList friends;
	private FriendRequestsList requestsList;
	
	
	public Member(int id, String name, boolean premiumMember, int category, float income, int houseArea,
			int houseResidents) {
		super(id, name);
		this.premiumMember = premiumMember;
		this.category = category;
		this.income = income;
		this.houseArea = houseArea;
		this.houseResidents = houseResidents;
		this.friends = new FriendsList();
		this.requestsList = new FriendRequestsList();
	}

	public void acceptFriendRequest(FriendRequest fr) {
		this.friends.addFriend(new Friend(fr.getSenderId(), 1));
		this.requestsList.deleteRequest(fr);
	}
	
	public FriendsList getFriends() {
		return friends;
	}

	public void setFriends(FriendsList friends) {
		this.friends = friends;
	}

	public FriendRequestsList getRequestsList() {
		return requestsList;
	}

	public void setRequestsList(FriendRequestsList requestsList) {
		this.requestsList = requestsList;
	}

	public void declineFriendRequest(FriendRequest fr) {
		this.requestsList.deleteRequest(fr);
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
