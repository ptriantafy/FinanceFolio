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
	    	Expense expense1 = new Expense("", "", 0.0);
	       //expenseinput
	        System.out.println("Add an Expense!\n");
	        System.out.println("Type Bill for Bill, Sub for Subscription or Misc for Miscellaneous");
	        String type = sc.nextLine();
	        // Expense is of type Bill
	        if(type.equalsIgnoreCase("Bill")) {
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
	        	//Bill Category: Water	
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
	        //Expense is of type Subscription
	        }else if(type.equalsIgnoreCase("Sub")) {
	        	Subscription sub1 = new Subscription("", 0.0);
	        	sub1.setCategory("Subscription");
	        	System.out.println("The selected category is: " + sub1.getSelectedCategory());
	        //Expense is of type Miscellaneous
	        }else if (type.equalsIgnoreCase("Misc")) {
	        	Miscellaneous misc1 = new Miscellaneous("", 0.0);
	        	misc1.setCategory("Miscellaneous");
	        	System.out.println("The selected category is: " + misc1.getSelectedCategory());
	        }
	    }
    
    

		
	}
   
}