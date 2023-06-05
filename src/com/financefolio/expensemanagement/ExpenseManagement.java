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
            Expense exp = expenseList.get(indx);
            
            //Print basic expense attributes
            System.out.print(exp.getName());
            System.out.print(" | ");
            System.out.print(exp.getAmount());
            System.out.print(" | ");
            System.out.print(exp.getAdditionDate());
            System.out.print(" | ");
            System.out.print(exp.getSelectedCategory());
            //Extended bill attributes
            if(exp instanceof Bill)
            {
                
                System.out.print(": ");
                System.out.print(((Bill)exp).getType());
                System.out.print(" | ");
                System.out.print(((Bill)exp).getOwed());
                System.out.print(" | ");
                System.out.print(((Bill)exp).getDateFrom());
                System.out.print(" | ");
                System.out.print(((Bill)exp).getDateTo());
            }
            else if(exp instanceof Subscription)
            {
                System.out.print(" | ");
                System.out.print(((Subscription)exp).getNextBillingDate());
            }
            else if(exp instanceof Miscellaneous)
            {
                for(int i =0; i < ((Miscellaneous)exp).getNumberOfMicroExpenses(); i++)
                {
                    Expense micro = ((Miscellaneous)exp).getMicroExpense(i);
                    //Print micro expense attributes
                    System.out.print("  ");
                    System.out.print(micro.getName());
                    System.out.print(" | ");
                    System.out.print(micro.getAmount());
                    System.out.print(" | ");
                    System.out.print(micro.getAdditionDate());
                    System.out.print(" | ");
                    System.out.print(micro.getSelectedCategory());

                }
            }
            System.out.println("");
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
        
        printList();
    }

}
