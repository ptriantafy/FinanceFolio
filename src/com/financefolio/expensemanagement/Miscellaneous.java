package com.financefolio.expensemanagement;

import java.util.ArrayList;
import java.util.List;

public class Miscellaneous extends Expense {

	List<Expense> microExpenses = new ArrayList<Expense>();
	int index = 0;
	    
	public Miscellaneous(String name, double amount) {
	        super.setCategory("Miscellaneous");
	        super.setAmount(amount);
	        super.setName(name);
	}

	public void appendMicroExpenses(Expense t)
	{
		microExpenses.add(t);
	}

	public void removeMicroExpenses(int index)
	{
		microExpenses.remove(index);
	}

	public void removeMicroExpenses(Expense t)
	{
		microExpenses.remove(t);
	}

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
}

