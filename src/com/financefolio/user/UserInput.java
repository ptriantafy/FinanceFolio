package com.financefolio.user;


import java.util.Scanner;


public class UserInput{
	
	 public void handleMembershipChoice(Member member) {
	        System.out.println("-------Settings-------\nWelcome!\nDo you plan to use this app for personal or collective use?");
	        Scanner sc = new Scanner(System.in);
	        String choice = sc.nextLine();

	        if (choice.equalsIgnoreCase("personal")) {
	            handlePersonalUse(member, sc);
	        } else if (choice.equalsIgnoreCase("collective")) {
	            handleCollectiveUse(member, sc);
	            handlePersonalUse(member, sc);
	        }
	    }

	   public void handlePersonalUse(Member member, Scanner sc) {
	        System.out.println("Please describe the reason why you are using the app, the goals you want to achieve, and what kind of customer you think you are.\n"
	                + "Reason: ");
	        String reason = sc.nextLine();
	        System.out.println("Goal: ");
	        String goal = sc.nextLine();
	        System.out.println("Kind of consumer: ");
	        String consumer = sc.nextLine();
	        System.out.println("Please fill in the square meters of your house and how many people live in it. (If you don't plan to fill in your house details, write 0 in the next 2 inputs.)\n Square meters: ");
	        int houseArea = sc.nextInt();
	        member.setHouseArea(houseArea);
	        System.out.println("Number of people: ");
	        int houseResidents = sc.nextInt();
	        member.setHouseResidents(houseResidents);
	        sc.nextLine();
	        if (houseArea==0 && houseResidents==0) {
	        	System.out.println("Note: You are excluded from comparing household bills with other users in your category!");
	        	
	        }
	        System.out.println("Please enter your work status and your income range. Work status: ");
	        String status = sc.nextLine();
	        System.out.println("Income range: ");
	        float income = sc.nextFloat();
	        if(status=="" && income==0) {
	        	
	           System.out.println("Note: You are exluded from comparing expenses with other users in your category. When you achieve goals, you will earn the minimum points.");
	        	
	        	
	        }
	        if (income >= 0 && income < 4000) {
	            member.setCategory(1);
	        } else if (income >= 4000 && income < 5500) {
	        	 member.setCategory(2);
	        } else if (income >= 5500 && income < 7500) {
	        	 member.setCategory(3);
	        } else {
	        	 member.setCategory(4);
	        }
	        member.updateIncome(income);
	        System.out.println("Select your membership (Basic or Premium).");
	        String membership = sc.next();
	        member.updateMembership(false);

	        if (membership.equalsIgnoreCase("Basic")) {
	            System.out.println("Excluded for premium features!\n\n");
	            member.displayUserInfo();
	            Member m = new Member(0, "", false, member.getCategory(), member.getIncome(), member.getHouseArea(), member.getHouseResidents());
	            m.displayMemberInfo();
	        } else if (membership.equalsIgnoreCase("Premium")) {
	            System.out.println("Please fill in points for a discount on the Premium Subscription: \n");
	            int points = sc.nextInt();
	            // Check for member's points
	            System.out.println("The Premium Subscription will cost x euros.\n");
	            // Payment made
	            member.updateMembership(true);
	            System.out.println("You have Premium Membership! You have access to all the functions of the app!");
	            member.displayUserInfo();
	            Member m = new Member(0, "", true, member.getCategory(), member.getIncome(), member.getHouseArea(), member.getHouseResidents());
	            m.displayMemberInfo();
	        }
	    }

	   public void handleCollectiveUse(Member member, Scanner sc) {
	    	System.out.println("Please fill in the number of people that will use the app and how many of them have income. \n Number of people:  ");
	        int number_of_people = sc.nextInt();
	        System.out.println("With income: ");
	        int people_with_income = sc.nextInt();
	       float[] incomes = new float[people_with_income]; 
	       String[] status = new String[people_with_income];
	        for (int i = 0; i < people_with_income; i++) {
	            System.out.println("Enter the income of person " + (i + 1) + ":");
	            incomes[i] = sc.nextFloat();
	            System.out.println("Enter the status of person " + (i + 1) + ":");
	            sc.nextLine();
	            status[i] = sc.nextLine();
	        }
	    }

}
