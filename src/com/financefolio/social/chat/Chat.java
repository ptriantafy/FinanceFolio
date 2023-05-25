package com.financefolio.social.chat;

import java.util.List;
import java.util.ArrayList;
public class Chat {
	private List<Message> messages;


	public Chat() {
		super();
		this.messages = new ArrayList<>();
	}

	public List<Message> getMessages() {
		return messages;
	}
	public void sendMessage(Message message) {
		this.messages.add(message);
	}
	
}
