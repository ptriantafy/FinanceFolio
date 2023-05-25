package com.financefolio.social.chat;

import java.sql.Timestamp;

public class Message {
	
	public Message(int id, int author_id, String body) {
		super();
		this.id = id;
		this.author_id = author_id;
		this.sentOn = new Timestamp(System.currentTimeMillis());
		this.body = body;
	}
	
	private int id;
	private int author_id;
	private Timestamp sentOn;
	private String body;
	
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
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
