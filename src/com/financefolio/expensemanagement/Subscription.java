package com.financefolio.expensemanagement;

   
public class Subscription extends Expense {

    public Subscription(String name, double amount) {
        super.setCategory("Subscription");
        super.setAmount(amount);
        super.setName(name);
    }
}
    
