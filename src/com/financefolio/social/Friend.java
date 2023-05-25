package com.financefolio.social;

import com.financefolio.social.chat.Chat;

public class Friend {

	private int id;
	private String name; 
	private String type;
	private int sharingLevel;
	private Chat conversation;
	
	public Friend(int id, String name, String type, int sharingLevel) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.sharingLevel = sharingLevel;
		this.conversation = new Chat();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
