package com.financefolio.expensemanagement;

import java.util.List;

public class Expense {
	
	private String category; //Expense type: Bills, Subscriptions or Misc.
	private String name;
    private String description = "";
    private int id;
    private double amount;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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



    public int getId()
    {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
    
    
    
}


class Bill extends Expense {
    public Bill(String name, double amount) {
        super.setCategory("Bill");
        super.setAmount(amount);
        super.setName(name);
    }
}

class Power extends Bill {
    public Power(String name, double amount) {
        super(name, amount);
    }
}

class Water extends Bill {
    public Water(String name, double amount) {
        super(name, amount);
    }
}

class Phone extends Bill {
    public Phone(String name, double amount) {
        super(name, amount);
    }
}

//sub-classes of expense

class Subscription extends Expense {

    public Subscription(String name, double amount) {
        super.setCategory("Subscription");
        super.setAmount(amount);
        super.setName(name);
    }
}

class Miscellaneous extends Expense {
    public Miscellaneous(String name, double amount) {
        super.setCategory("Miscellaneous");
        super.setAmount(amount);
        super.setName(name);
    }
}

//  //example main
//  public static void main(String[] args) {
//     ExpenseList expensesList = new ExpenseList();
    
//     Expense bill1 = new Expense("Bill", "Phone BIll", 340.0);
//     Expense sub1 = new Expense("Subscription", "Spotify", 6.99);
//     Expense misc1 =  new Expense("Miscellaneous", "Groceries", 52.0);
    
//     expensesList.addExpensesInList(bill1);
//     expensesList.addExpensesInList(sub1);
//     expensesList.addExpensesInList(misc1); 
    
//     List<Expense> expenseList1 = expensesList.getAllExpensesList(); 
    
//     for (Expense expense0 : expenseList1) {
//         System.out.println("Category: " + expense0.getSelectedCategory());
//         System.out.println("Name: " + expense0.getName());
//         System.out.println("Amount: " + expense0.getAmount());
//         System.out.println();
//     }
    
// }