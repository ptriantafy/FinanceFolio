package com.financefolio.social;

import com.financefolio.social.chat.Chat;

public class Friend {

	private int id;
	private String name; 
	private int sharingLevel;
	private Chat conversation;
	
	public Friend(int id, int sharingLevel) {
		super();
		this.id = id;
		this.sharingLevel = sharingLevel;
		this.conversation = new Chat();
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

}
