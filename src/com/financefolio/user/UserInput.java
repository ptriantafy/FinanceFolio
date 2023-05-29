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
	        }
	    }

	    private void handlePersonalUse(Member member, Scanner sc) {
	        System.out.println("Please describe the reason why you are using the app, the goals you want to achieve, and what kind of customer you think you are.\n"
	                + "Reason: ");
	        String reason = sc.nextLine();
	        System.out.println("Goal: ");
	        String goal = sc.nextLine();
	        System.out.println("Kind of consumer: ");
	        String consumer = sc.nextLine();
	        System.out.println("Please fill in the square meters of your house and how many people live in it.\n Square meters: ");
	        int houseArea = sc.nextInt();
	        member.setHouseArea(houseArea);
	        System.out.println("Number of people: ");
	        int houseResidents = sc.nextInt();
	        member.setHouseResidents(houseResidents);
	        sc.nextLine();
	        System.out.println("Please enter your work status and your income range. Work status: ");
	        String status = sc.nextLine();
	        System.out.println("Income range: ");
	        float income = sc.nextFloat();
	        member.updateIncome(income);
	        System.out.println("Select your membership (Basic or Premium).");
	        String membership = sc.next();
	        member.updateMembership(false);

	        if (membership.equalsIgnoreCase("Basic")) {
	            System.out.println("Excluded for premium features!\n\n");
	            member.displayUserInfo();
	            Member m = new Member(0, "", false, 0, member.getIncome(), member.getHouseArea(), member.getHouseResidents());
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
	            Member m = new Member(0, "", true, 0, member.getIncome(), member.getHouseArea(), member.getHouseResidents());
	            m.displayMemberInfo();
	        }
	    }

	    private void handleCollectiveUse(Member member, Scanner sc) {
	        // Collective app behavior
	    }

}
