package com.financefolio.user;

import java.util.Date;
import java.util.Scanner;
import com.financefolio.user.User;


public class User {
	private int id;
	private String name;
	private Date registerDate;
	
   public static void main(String[] args) {
	   
	 	
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("Enter user ID:");
	 int userId = scanner.nextInt();
	 scanner.nextLine();
	 System.out.println("Enter user name:");
	 String userName = scanner.nextLine();
	
	 User newUser = new User(userId, userName);
	 newUser.displayUserInfo();
	 System.out.println("Creation Date: " + newUser.getRegisterDate());
	 
	 Member member = new Member(newUser.getId(), newUser.getName(), false, 0, 0.0f, 0, 0);
	 UserInput userinput = new UserInput();
	 userinput.handleMembershipChoice(member);
	 
	 }
   
   public User() {}
	 
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.registerDate = new Date();
	}
	
	protected void displayUserInfo() {
	    System.out.println("User ID: " + id);
	    System.out.println("User Name: " + name);
	    
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
