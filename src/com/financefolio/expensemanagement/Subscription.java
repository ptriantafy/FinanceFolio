package com.financefolio.expensemanagement;
import java.sql.Date;
   
public class Subscription extends Expense {


    private Date next_billing_date;


    public Date getNextBillingDate() {
        return next_billing_date;
    }
    public void setNextBillingDate(Date next_billing_date) {
        this.next_billing_date = next_billing_date;
    }
    public Subscription(String name, double amount) {
        super.setCategory("Subscription");
        super.setAmount(amount);
        super.setName(name);
    }
}
    
