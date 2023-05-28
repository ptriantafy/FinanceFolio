package com.financefolio.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.financefolio.social.Friend;

public class Member extends User {
	private User newUser;
	private boolean premiumMember;
	private int category;
	private float income;
	private int houseArea;
	private int houseResidents;
	private List<Friend> friends;
	
	public void Choice() {
		System.out.println("-------Settings-------\n Welcome! \n Do you plan to use this app for personal or collective use?");
		Scanner sc =  new Scanner(System.in);
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("personal")) {
			System.out.println("Please describe the reason why you are using the app, the goals you want to achieve and what kind of customer you think you are.\n"
					+ "Reason: ");
			String reason = sc.nextLine();
			System.out.println("Goal: ");
			String goal = sc.nextLine();
			System.out.println("Kind of consumer: ");
			String consumer = sc.nextLine();
			System.out.println("Please fill in the square meters of your house and how many people live in it.\n Square meters: ");
			int house_area = sc.nextInt();
			setHouseArea(house_area);
			System.out.println("Number of people: ");
            int house_residents = sc.nextInt();
            setHouseResidents(house_residents);
            sc.nextLine();
            System.out.println("Please enter your work status and your income range. Work status: ");
			String status = sc.nextLine();
			System.out.println("Income range: ");
            float user_income = sc.nextInt();
            updateIncome(user_income);
            System.out.println("Select your membership.(Basic or premium).");
            Scanner sc1 =  new Scanner(System.in);
            String membership = sc1.nextLine();
            updateMembership(false);
			
			if(membership.equalsIgnoreCase("Basic")) {
				System.out.println("Excluded for premium features!\n\n");
				super.displayUserInfo();
				Member M = new Member(0,"", false, 0, getIncome(), getHouseArea(), getHouseResidents());
				M.displayMemberInfo();
				
				
			}else {
				System.out.println("pipa");
			}
            
		}
	
	}
	
	
		
		
		

	
	public Member(int id, String name, boolean premiumMember, int category, float income, int houseArea,
			int houseResidents) {
		super(id, name);
		this.premiumMember = premiumMember;
		this.category = category;
		this.income = income;
		this.houseArea = houseArea;
		this.houseResidents = houseResidents;
	    this.friends = new ArrayList<>();
	}

	
	protected void displayMemberInfo() {
	    System.out.println("Premium Member :" + premiumMember);
	    System.out.println("Income: " + income);
	    System.out.println("Square Meters: " + houseArea);
	    System.out.println("Number of Residents: " + houseResidents);
	}	
	
	public void updateHouseDetails(int area, int residents) {
		this.setHouseArea(area);
		this.setHouseResidents(residents);
	}

	
	public boolean isPremiumMember() {
		return premiumMember;
	}
	public void updateMembership(boolean membership) {
		this.premiumMember = membership;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void addFriend(Friend friend) {
		this.friends.add(friend);
	}

	public void removeFromFriendsList(Friend friend) {
		this.friends.remove(friend);
	}
	
	public boolean isFriendsListEmpty(){
		return friends.isEmpty();
	}
	public int getHouseResidents() {
		return houseResidents;
	}
	public void setHouseResidents(int houseResidents) {
		this.houseResidents = houseResidents;
	}
	public int getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(int houseArea) {
		this.houseArea = houseArea;
	}
	public float getIncome() {
		return income;
	}
	public void updateIncome(float income) {
		this.income = income;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
}


