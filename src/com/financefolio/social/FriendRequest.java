package com.financefolio.social;

import java.sql.Timestamp;

public class FriendRequest {

	private int requestId;
	private int senderId;
	private int receiverId;
	private int senderSharingLevel;
	private Timestamp sentOn;
	
	public FriendRequest(int requestId, int senderId, int receiverId, int senderSharingLevel, Timestamp sentOn) {
		super();
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.senderSharingLevel = senderSharingLevel;
		this.sentOn = sentOn;
	}

	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int id) {
		this.requestId = id;
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

	public int getSenderSharingLevel() {
		return senderSharingLevel;
	}

	public void setSenderSharingLevel(int senderSharingLevel) {
		this.senderSharingLevel = senderSharingLevel;
	}


}
