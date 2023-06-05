package com.financefolio.social;

import java.util.List;
import java.util.stream.Collectors;
import com.financefolio.dao.FriendDAO;
import com.financefolio.dao.MessageDAO;
import com.financefolio.premiumfeatures.PremiumFeatureToken;
import com.financefolio.social.chat.Message;

import java.util.ArrayList;

public class FriendsList {

	private List<Friend> friendsList;
	public FriendsList() {
		super();
		this.friendsList = new ArrayList<>();
	}
	
	public void removeFriend(Friend friend) {
		FriendDAO fDAO = new FriendDAO();
		MessageDAO messDAO = new MessageDAO();
		try {
			fDAO.delete(friend);
//			passing a dummy message as argument in case conversation = null
			messDAO.delete(new Message(-1, -1, -1, "Dummy Message", null, friend.getConversation().getChat_id()));
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
	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}
    public String toString() {
        return this.getFriendsList().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
