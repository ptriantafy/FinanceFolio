package com.financefolio.expensemanagement;

public class Bill extends Expense {

    private String type = "power";

    public Bill(String type, String name, double amount) {
        super.setCategory("Bill");
        super.setAmount(amount);
        super.setName(name);
        this.type = type;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
}