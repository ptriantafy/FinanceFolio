package com.financefolio.social;

import java.util.List;
import java.util.stream.Collectors;

import com.financefolio.dao.FriendDAO;

import java.util.ArrayList;

public class FriendsList {

	private List<Friend> friendsList;
	public FriendsList() {
		super();
		this.friendsList = new ArrayList<>();
	}
	

	public void removeFriend(Friend friend) {
		FriendDAO fDAO = new FriendDAO();
		try {
			fDAO.delete(friend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.friendsList.remove(friend);
	}
	
	public void addFriend(Friend newFriend) {
		this.friendsList.add(newFriend);
	}
	
	public boolean isFriendsListEmpty(){
		return friendsList.isEmpty();
	}
	public List<Friend> getFriendsList() {
		return friendsList;
	}
    public String toString() {
        return this.getFriendsList().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
