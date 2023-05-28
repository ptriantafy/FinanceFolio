package com.financefolio.user;

import java.util.Scanner;
import com.financefolio.user.User;
import java.util.Scanner;

public class User {
	private int id;
	private String name;
	
   public static void main(String[] args) {
	
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("Enter user ID:");
	 int userId = scanner.nextInt();
	 scanner.nextLine();
	 System.out.println("Enter user name:");
	 String userName = scanner.nextLine();
	
	 User newUser = new User(userId, userName);
	 newUser.displayUserInfo();
	 
	 Member member = new Member(newUser.getId(), newUser.getName(), false, 0, 0.0f, 0, 0);
	 member.Choice();
	 }
	 
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
