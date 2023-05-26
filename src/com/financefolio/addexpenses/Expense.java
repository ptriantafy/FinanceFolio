package com.financefolio.addexpenses;
import java.util.ArrayList;
import java.util.List;

public class Expense {
	
	private String category; //Expense type: Bills, Subscriptions or Misc.
	private String name;
    private double amount;

	private Expense(String category, String name, double amount){
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
    
    class Bill extends Expense {
        public Bill(String name, double amount) {
            super("Bill", name, amount);
        }
    }
    
    class Power extends Bill {
        public Power(String name, double amount) {
            super("Power", name, amount);
        }
    }
    
    class Water extends Bill {
        public Water(String name, double amount) {
            super("Water", name, amount);
        }
    }

    class Phone extends Bill {
        public Phone(String name, double amount) {
            super("Phone", name, amount);
        }
    }
	
	//sub-classes of expense
    
    class Subscription extends Expense {

        public Subscription(String name, double amount) {
            super("Subscription", name, amount);
        }

    class Miscellaneous extends Expense {
        public Miscellaneous(String name, double amount) {
            super("Miscellaneous", name, amount);
        }
    }
}
