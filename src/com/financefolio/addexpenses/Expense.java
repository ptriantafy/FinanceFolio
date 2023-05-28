package com.financefolio.addexpenses;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public static void main(String[] args){
    	 List<Expense> expenses = new ArrayList<>();

         // Adding different types of expenses
         expenses.add(new Power("Electricity Bill", 100.0));
         expenses.add(new Water("Water Bill", 50.0));
         expenses.add(new Phone("Phone Bill", 30.0));
         expenses.add(new Subscription("Monthly reminder", 15.0));
         expenses.add(new Miscellaneous("Misc Item", 10.0));

         // Printing the expenses
         for (Expense expense : expenses) {
             System.out.println("Category: " + expense.getSelectedCategory());
             System.out.println("Name: " + expense.getName());
             System.out.println("Amount: " + expense.getAmount());
             System.out.println();
         }
		
	
	}
}
