package com.financefolio.addexpenses;
import java.util.ArrayList;
import java.util.List;

public class Expense {
	
	private String type; //Expense type: Bills, Subscriptions or Misc.

	private Expense(String type){
		this.type = type;
	}
	
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
