package com.financefolio.expensemanagement;

import java.sql.Date;

public class Expense {
	
	private String category; //Expense type: Bills, Subscriptions or Misc.
	private String name;
    private String description = "";
    private int id;
    private double amount;
    private Date addition_date;

    public Date getAddition_date() {
        return addition_date;
    }

    public void setAddition_date(Date addition_date) {
        this.addition_date = addition_date;
    }

    public void init(double amount, String category, String name, String description)
    {
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


