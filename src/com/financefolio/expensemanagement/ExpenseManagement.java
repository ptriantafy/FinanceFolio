package com.financefolio.expensemanagement;

import com.financefolio.dao.*;
import java.util.ArrayList;
import java.util.List;


public class ExpenseManagement {
    private List<Expense> expenseList = new ArrayList<Expense>();

    public void printList()
    {
        for(int indx = 0; indx < expenseList.size(); indx++)
        {
            System.out.print();
        }
    }

    public void manageExpensesScene()
    {
        ExpenseDAO expDAO = new ExpenseDAO();

        try {
            this.expenseList = (expDAO.getAll(0)).get();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}
