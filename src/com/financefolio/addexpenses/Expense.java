package com.financefolio.addexpenses;

import java.util.List;
import java.util.Scanner;

public class Expense {
	
	private String category; //Expense type: Bills, Subscriptions or Misc.
	private String name;
    private double amount;

	public Expense(String category, String name, double amount){
		this.category = category;
		this.name = name; 
		this.amount = amount;
	}
	

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getSelectedCategory() {
    	return category; 	
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    //sub-classes for expense and for bill
    
    public static class Bill extends Expense {
        public Bill(String name, double amount) {
            super("Bill", name, amount);
        }
    }
    
    public static class Power extends Bill {
        public Power(String name, double amount) {
            super(name, amount);
        }
    }
    
    public static class Water extends Bill {
        public Water(String name, double amount) {
            super(name, amount);
        }
    }

    public static class Phone extends Bill {
        public Phone(String name, double amount) {
            super(name, amount);
        }
    }
	
	//sub-classes of expense
    
    public static class Subscription extends Expense {

        public Subscription(String name, double amount) {
            super("Subscription", name, amount);
        }
    }

    public static class Miscellaneous extends Expense {
        public Miscellaneous(String name, double amount) {
            super("Miscellaneous", name, amount);
        }
    }
    
    //example main
    public static void main(String[] args) {
		/*ExpenseList expensesList = new ExpenseList();
		
		Expense bill1 = new Expense("Bill", "Phone BIll", 340.0);
		Expense sub1 = new Expense("Subscription", "Spotify", 6.99);
		Expense misc1 =  new Expense("Miscellaneous", "Groceries", 52.0);
		
		expensesList.addExpensesInList(bill1);
		expensesList.addExpensesInList(sub1);
		expensesList.addExpensesInList(misc1); 
		
		List<Expense> expenseList1 = expensesList.getAllExpensesList(); 
		
		for (Expense expense0 : expenseList1) {
	        System.out.println("Category: " + expense0.getSelectedCategory());
	        System.out.println("Name: " + expense0.getName());
	        System.out.println("Amount: " + expense0.getAmount());
	        System.out.println();
	    }
	    */
    	 System.out.println("Welcome to Expenses!\nWrite Add to add an expense!");
	        Scanner sc = new Scanner(System.in);
	        String choice = sc.nextLine();

	        if (choice.equalsIgnoreCase("add")) {
	            //expenseinput
	        	System.out.println("Add an Expense!\n");
	        	System.out.println("Type Bill for Bill, Sub for Subscription or Misc for Miscellaneous");
	        	String type = sc.nextLine();
	        	if(type.equalsIgnoreCase("Bill")) {
	        		System.out.println("0");
	        	}else if(type.equalsIgnoreCase("Sub")) {
	        		System.out.println("1");
	        	}else if (type.equalsIgnoreCase("Misc")) {
	        		System.out.println("2");
	        	}
	    }
    
    

		
	}
   
}