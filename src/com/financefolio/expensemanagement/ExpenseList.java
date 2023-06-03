package com.financefolio.expensemanagement;

import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
	private int number = 0;
	private List<Expense> expensesInList;
	
	public ExpenseList() {
		expensesInList = new ArrayList<>(); 
		
	}
	
	public void addExpensesInList(Expense newExpense) {
		expensesInList.add(newExpense);
		number++; 
	}
	
	public void updateInList(int number, List<Expense> expensesInList) {
		this.number = number;
		this.expensesInList = expensesInList; 
	}
	
	public List<Expense> getAllExpensesList() {
		return expensesInList; 
	}
	
}
