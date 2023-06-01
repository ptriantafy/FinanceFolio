package com.financefolio.addexpenses;

import java.util.List;

import java.util.Scanner;

import com.financefolio.addexpenses.ExpenseInput;

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
    	private String billCategory; //power, water or phone 
    	
        public Bill(String name, double amount, String billCategory) {
            super("Bill", name, amount);
            this.billCategory = billCategory; 
        }
        
        public String getBillCategory() {
            return billCategory;
        }
        
        public void setBillCategory(String billCategory) {
        	this.billCategory = billCategory; 
        }
    }
        
    
    
    public static class Power extends Bill {
        public Power(String name, double amount) {
            super(name, amount, "Power");
        }
    }
    
    public static class Water extends Bill {
        public Water(String name, double amount) {
            super(name, amount, "Water");
        }
    }

    public static class Phone extends Bill {
        public Phone(String name, double amount) {
            super(name, amount, "Phone");
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
		
    	ExpenseList expensesList = new ExpenseList();
    	System.out.println("Welcome to Expenses!\nWrite Add to add an expense!");
	    Scanner sc = new Scanner(System.in);
	    String choice = sc.nextLine();
	    
	    if (choice.equalsIgnoreCase("add")) {
	    	ExpenseInput ExpenseInput1 =  new ExpenseInput();
	    	ExpenseInput1.addExpense(); 
	    }
    
    }
   
}