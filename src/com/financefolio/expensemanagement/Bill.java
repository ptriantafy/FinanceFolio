package com.financefolio.expensemanagement;

public class Bill extends Expense {

    private String type = "power";

    public Bill(String type, String name, double amount) {
        super.setCategory("Bill");
        super.setAmount(amount);
        super.setName(name);
        this.type = type;
    }
}