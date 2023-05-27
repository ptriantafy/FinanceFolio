package com.financefolio.social;

import java.sql.Date;

import com.financefolio.social.chat.Chat;

public class Friend {

	private int id;
	private String name; 
	private int sharingLevel;
	private Chat conversation;
	private Date friendsSince;
	
	public Friend(int id, int sharingLevel, int chat_id, Date friendsSince) {
		super();
		this.id = id;
		this.sharingLevel = sharingLevel;
		this.conversation = new Chat(chat_id);
		this.friendsSince = friendsSince;
//		get name from UserDAO?
		this.setName(null);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSharingLevel() {
		return sharingLevel;
	}

	public void setSharingLevel(int sharingLevel) {
		this.sharingLevel = sharingLevel;
	}

	public Chat getConversation() {
		return conversation;
	}

	public Date getFriendsSince() {
		return friendsSince;
	}

	public void setFriendsSince(Date friendsSince) {
		this.friendsSince = friendsSince;
	}

}
