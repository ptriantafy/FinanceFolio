package com.financefolio.expensemanagement;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.List;
import java.sql.Date;

public class ExpenseInput {

	Scanner sc = new Scanner(System.in);
	public void addExpense() {		
	    //expenseinput
	    System.out.println("Add an Expense!\n");
	    System.out.println("Type Bill for Bill, Sub for Subscription or Misc for Miscellaneous");
	    String type = sc.nextLine();
	    	// Expense is of type Bill
	    if(type.equalsIgnoreCase("Bill")) {
	    	addBill();
	        //Expense is of type Subscription
	    }else if(type.equalsIgnoreCase("Sub")) {
	    	addSubscription();
	        //Expense is of type Miscellaneous
	    }else if (type.equalsIgnoreCase("Misc")) {
	    	addMiscellaneous();
	    }else {
	    	 System.out.println("Invalid Input. Try again!\n");
	    	 addExpense();
	    }

		sc.close();
	}
	
	private void addBill() {
		Scanner sc = new Scanner(System.in);
		Bill bill1 = new Bill("", 0.0);
        bill1.setCategory("Bill");
        System.out.println("The selected category is: " + bill1.getSelectedCategory());
        System.out.println("power, water or phone?");
       	String billType = sc.nextLine();
        //Bill Category: Power
        if(billType.equalsIgnoreCase("power")) {
        	bill1.setType("power");
        	addPower(bill1);
        }else if(billType.equalsIgnoreCase("water")) {
        	bill1.setType("water");
        	addWater(bill1);
        //Bill Category: Phone
        }else if(billType.equalsIgnoreCase("phone")) {
        	bill1.setType("telephony");
        	addPhone(bill1);
        }
		else {
			System.out.println("Invalid Input. Try again!\n");
			addBill();
	   }
		sc.close();
	}
	
	private void addPower(Bill bl) {
	     System.out.println("Time to set the time frame of the Power Bill");
	     System.out.println("Date from:");
	     String date_from = sc.nextLine();
		 Date date_f = Date.valueOf(date_from);
		 bl.setDateFrom(date_f);


		 System.out.println("Date to:");
	     String date_to = sc.nextLine();
		 Date date_t = Date.valueOf(date_from);
	     System.out.println("What is the cost of the Power Bill?");
		    double subAmount = 0.0;
		    try {
		        subAmount = sc.nextDouble();
		        sc.nextLine(); // Consume the remaining newline character
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input for the Power Bill amount. Please enter a numeric value.");
		        sc.nextLine(); // Consume the invalid input
		        addSubscription(); // Retry adding the subscription
		        return;
		    }
		    bl.setAmount(subAmount);
		    System.out.println("Your Power Bill for the month : " + bl.getName() + " has been added to the Expense List");
		    return;

	}
	
	private void addWater(Bill bl) {
	     System.out.println("Write the month of the Water Bill");
	     String waterMonth = sc.nextLine();
	     bl.setName(waterMonth);
	     System.out.println("What is the cost of the Water Bill?");
		    double subAmount = 0.0;
		    try {
		        subAmount = sc.nextDouble();
		        sc.nextLine(); // Consume the remaining newline character
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input for the Water Bill amount. Please enter a numeric value.");
		        sc.nextLine(); // Consume the invalid input
		        addSubscription(); // Retry adding the subscription
		        return;
		    }
		    bl.setAmount(subAmount);
		    System.out.println("Your Water Bill for the month : " + bl.getName() + " has been added to the Expense List");
		    return;

	}
	
	private void addPhone(Bill bl) {
	     System.out.println("Write the month of the Phone Bill");
	     String powerMonth = sc.nextLine();
	     bl.setName(powerMonth);
	     System.out.println("What is the cost of the Phone Bill?");
		    double subAmount = 0.0;
		    try {
		        subAmount = sc.nextDouble();
		        sc.nextLine(); // Consume the remaining newline character
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input for the Phone Bill amount. Please enter a numeric value.");
		        sc.nextLine(); // Consume the invalid input
		        addSubscription(); // Retry adding the subscription
		        return;
		    }
		    bl.setAmount(subAmount);
		    System.out.println("Your Phone Bill for the month : " + bl.getName() + " has been added to the Expense List");
		    return;

	}
	
	private void addSubscription() {
		Subscription sub1 = new Subscription("", 0.0);
	    sub1.setCategory("Subscription");
	    System.out.println("The selected category is: " + sub1.getSelectedCategory());
	    System.out.println("What is the name of the Subscription");
	    String subName = sc.nextLine();
	    sub1.setName(subName); 
	    System.out.println("What is the cost of the Subscription");
	    double subAmount = 0.0;
	    try {
	        subAmount = sc.nextDouble();
	        sc.nextLine(); // Consume the remaining newline character
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input for the Subscription amount. Please enter a numeric value.");
	        sc.nextLine(); // Consume the invalid input
	        addSubscription(); // Retry adding the subscription
	        return;
	    }
	    sub1.setAmount(subAmount);
	    System.out.println("Your Subscription with name: " + sub1.getName() + " has been added to the Expense List");
	    //!theoretically it has to go to the calendar now!
	    return;
	}
	
	private void addMiscellaneous() {
		ExpenseList miscList1 = new ExpenseList();
		int numberOfMisc = 0;
	    System.out.println("How many expenses would you like to add?");
	    try {
	        numberOfMisc = sc.nextInt();
	        sc.nextLine(); // Consume the remaining newline character
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input for the number of expenses. Please enter a numeric value.");
	        sc.nextLine(); // Consume the invalid input
	        addMiscellaneous(); // Retry adding miscellaneous expenses
	        return;
	    }
	    
	    for (int i = 0; i < numberOfMisc; i++) {
	        System.out.println("\nExpense " + (i + 1));
	        System.out.println("Enter the name of the Miscellaneous expense:");
	        String name = sc.nextLine();
	        System.out.println("Enter the amount of the Miscellaneous expense:");
	        double amount = 0.0;
	        try {
	            amount = sc.nextDouble();
	            sc.nextLine(); // Consume the remaining newline character
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input for the amount. Please enter a numeric value.");
	            sc.nextLine(); // Consume the invalid input
	            i--; // Retry adding the current expense
	            continue;
	        }
	        
	        Miscellaneous misc1 = new Miscellaneous(name, amount);
	        miscList1.addExpensesInList(misc1);
	        System.out.println("Miscellaneous expense " + (i + 1) + " added to the Expense List");
	        
	    }
        //add the misc expenses to the expenselist for miscellaneous expenses 
        System.out.println("\nMiscellaneous Expense List: ");
        List<Expense> allExpenses = miscList1.getAllExpensesList();
        for (Expense expense : allExpenses) {
            System.out.println(expense);
        }
        
	}
	    
	    
	
	
}