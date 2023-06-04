package com.financefolio.points;

import java.sql.Timestamp;

public class Points {
	private int id;
	private int amount;
	private Timestamp timestamp;
	private String reason;
	
	public Points(int id, int amount, Timestamp timestamp, String reason) {
		super();
		this.id = id;
		this.amount = amount;
		this.timestamp = timestamp;
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
