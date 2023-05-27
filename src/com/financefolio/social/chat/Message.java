package com.financefolio.social.chat;

import java.sql.Timestamp;

public class Message {
	private int id;
	private int sender_id;
	private int receiver_id;
	private Timestamp sentOn;
	private String body;
	private int chat_id;
	
	public Message(int id, int sender_id, int receiver_id, String body, Timestamp sent_on, int chat_id) {
		super();
		this.id = id;
		this.sender_id = sender_id;
		this.setReceiver_id(receiver_id);
		this.sentOn = sent_on;
		this.body = body;
		this.chat_id = chat_id;
	}
	
	
	public Timestamp getSentOn() {
		return sentOn;
	}
	public void setSentOn(Timestamp sentOn) {
		this.sentOn = sentOn;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int author_id) {
		this.sender_id = author_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getReceiver_id() {
		return receiver_id;
	}


	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}


	public int getChat_id() {
		return chat_id;
	}


	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}
}
