package com.financefolio.expensemanagement;


import java.sql.Date;

public class Bill extends Expense {

    private String type = "";
    private double owed = 0.0;
    private Date date_from ;
    private Date date_to ;
    



    public Date getDateFrom() {
        return date_from;
    }

    public void setDateFrom(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDateTo() {
        return date_to;
    }

    public void setDateTo(Date date_to) {
        this.date_to = date_to;
    }


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