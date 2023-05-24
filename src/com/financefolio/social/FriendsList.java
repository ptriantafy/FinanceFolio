package com.financefolio.social;

import java.util.List;

public class FriendsList {
	private List<Friend> friends;

	public List<Friend> getFriends() {
		return friends;
	}

	public void addToList(Friend friend) {
		this.friends.add(friend);
	}
	
	public void removeFromList(Friend friend) {
		this.friends.remove(friend);
	}
	
	public boolean isListEmpty(){
		return friends.isEmpty();
	}
}
