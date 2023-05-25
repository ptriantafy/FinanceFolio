package com.financefolio.social;

import java.sql.Timestamp;

public class FriendRequest {

	private int requestId;
	private int senderId;
	private int receiverId;
	private Timestamp sentOn;
	
	public FriendRequest(int requestId, int senderId, int receiverId) {
		super();
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sentOn = new Timestamp(System.currentTimeMillis());
	}

	public int getRequestId() {
		return requestId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public Timestamp getSentOn() {
		return sentOn;
	}

	public void setSentOn(Timestamp sentOn) {
		this.sentOn = sentOn;
	}

	public String getSenderName() {
		return null;
//		++DAO search name etc
	}

}
