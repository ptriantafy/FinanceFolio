package com.financefolio.expensemanagement;



public class Expense {
	
	private String category; //Expense type: Bills, Subscriptions or Misc.
	private String name;
    private String description = "";
    private int id;
    private double amount;


    public void init(int id, double amount, String category, String name, String description)
    {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.name = name;
        this.description = description;
    }

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


