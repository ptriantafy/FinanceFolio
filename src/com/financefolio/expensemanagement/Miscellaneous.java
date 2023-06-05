package com.financefolio.expensemanagement;

import java.security.cert.PKIXBuilderParameters;
import java.util.ArrayList;
import java.util.List;

public class Miscellaneous extends Expense {

	List<Expense> microExpenses = new ArrayList<Expense>();
	
	//update sum is called every time a micro expense is added in the miscellaneous 
	//expense category. it is used for calculating the total cost of the 
	//current miscellanaous expense
	private void updateSum(char s, double cost)
	{
		//if the sign is + add to the cost
		if(s == '+')
		{
			this.setAmount((this.getAmount()+cost));
		}
		//if the sign is - subtract from the cost
		else if(s == '-')
		{
			this.setAmount((this.getAmount()-cost));
		}
	}
	    
	public Miscellaneous(String name, double amount) {
	        super.setCategory("Miscellaneous");
	        super.setAmount(amount);
	        super.setName(name);
	}

	public void appendMicroExpenses(Expense t)
	{
		this.updateSum('+', t.getAmount());
		microExpenses.add(t);
	}

	public void removeMicroExpenses(int index)
	{
		Expense exp = microExpenses.get(index);
		this.updateSum('-', exp.getAmount());
		microExpenses.remove(index);
	}

	public void removeMicroExpenses(Expense t)
	{
		this.updateSum('-', t.getAmount());
		microExpenses.remove(t);
	}

	public int getNumberOfMicroExpenses()
	{
		return this.microExpenses.size();
	}

	public Expense getMicroExpense(int index)
	{
		return this.microExpenses.get(index);
	}


	
}

