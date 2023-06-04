package com.financefolio.expensemanagement;

public class Bill extends Expense {

    private String type = "";
    private double owed = 0.0;

    public Bill(String type, String name, double amount, double owed) {
        super.setCategory("Bill");
        super.setAmount(amount);
        super.setName(name);
        this.type = type;
        this.owed = owed;
    }
    
    public double getOwed() {
        return owed;
    }

    public void setOwed(double owed) {
        this.owed = owed;
    }

    public String getType()
    {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
}