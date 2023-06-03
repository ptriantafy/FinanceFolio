package com.financefolio.user;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private Date registerDate;
	
	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.registerDate = date;
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
