package com.financefolio.social.chat;

import java.util.List;

import com.financefolio.dao.MessageDAO;

import java.util.ArrayList;
public class Chat {
	private List<Message> messages;
	private int chat_id;

	public Chat(int id) {
		super();
		this.chat_id = id;
		this.messages = new ArrayList<>();
	}
	
	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void sendMessage(Message message) {
		MessageDAO mDAO = new MessageDAO();
		try {
			mDAO.save(message, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.messages.add(message);
	}
	@Override
    public String toString() {
        return this.getMessages().toString();
    }
}
