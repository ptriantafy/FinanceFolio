package com.financefolio.addexpenses;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

import com.financefolio.addexpenses.Expense.Bill;
import com.financefolio.addexpenses.Expense.Miscellaneous;
import com.financefolio.addexpenses.Expense.Phone;
import com.financefolio.addexpenses.Expense.Power;
import com.financefolio.addexpenses.Expense.Subscription;
import com.financefolio.addexpenses.Expense.Water;

public class ExpenseInput {
	Scanner sc = new Scanner(System.in);
	public void addExpense() {		
		Expense expense1 = new Expense("", "", 0.0);
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
	}
	
	private void addBill() {
		Bill bill1 = new Bill("", 0.0, "");
        bill1.setCategory("Bill");
        System.out.println("The selected category is: " + bill1.getSelectedCategory());
        System.out.println("Is it Power, Water or Phone?");
       	String billType = sc.nextLine();
        //Bill Category: Power
        if(billType.equalsIgnoreCase("power")) {
        bill1.setBillCategory("Power");
        Power power1 = new Power("", 0.0);
        power1.setBillCategory("Power");
        System.out.println("The selected category is: " + power1.getSelectedCategory());
        System.out.println("The selected Bill category is: " + power1.getBillCategory());
        }else if(billType.equalsIgnoreCase("water")) {
        	bill1.setBillCategory("Water");
        	Water water1 = new Water("", 0.0);
        	System.out.println("The selected category is: " + water1.getSelectedCategory());
        	System.out.println("The selected Bill category is: " + water1.getBillCategory());	
        //Bill Category: Phone
        }else if(billType.equalsIgnoreCase("phone")) {
        	bill1.setBillCategory("Phone");
        	Phone phone1 = new Phone("", 0.0);
        	System.out.println("The selected category is: " + phone1.getSelectedCategory());
        	System.out.println("The selected Bill category is: " + phone1.getBillCategory());
        }
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
	        System.out.println("Invalid input for the subscription amount. Please enter a numeric value.");
	        sc.nextLine(); // Consume the invalid input
	        addSubscription(); // Retry adding the subscription
	        return;
	    }
	    sub1.setAmount(subAmount);
	    System.out.println("Your Subscription with name: " + sub1.getName() + " has been added to the Expense List");
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
        
        System.out.println("\nMiscellaneous Expense List: ");
        /*for (int i = 0; i < numberOfMisc; i++) {
            System.out.println(miscList1.getAllExpensesList());
        }*/
        List<Expense> allExpenses = miscList1.getAllExpensesList();
        for (Expense expense : allExpenses) {
            System.out.println(expense);
        }
        
	}
	    
	    
	
	
}