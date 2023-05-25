package com.financefolio.social;

import java.util.List;

import java.util.ArrayList;

public class FriendsList {

	private List<Friend> friendsList;
	public FriendsList() {
		super();
		this.friendsList = new ArrayList<>();
	}
	

	public void removeFriend(Friend friend) {
		this.friendsList.remove(friend);
	}
	
	public boolean isFriendsListEmpty(){
		return friendsList.isEmpty();
	}

	public List<Friend> getFriendsList() {
		return friendsList;
	}
	public void addFriend(Friend newFriend) {
		this.friendsList.add(newFriend);
	}

}
