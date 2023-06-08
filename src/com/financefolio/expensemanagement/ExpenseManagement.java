package com.financefolio.expensemanagement;

import com.financefolio.dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManagement {
    private List<Expense> expenseList = new ArrayList<Expense>();
    
    public void printList()
    {
        
        for(int indx = 0; indx < expenseList.size(); indx++)
        {
            System.out.print((indx+1)+")");
            Expense exp = expenseList.get(indx);
            this.printExpenseDetails(exp);
            
        }
    }

    private void printExpenseDetails(Expense exp)
    {
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
                System.out.println("");
                System.out.print("  ");
                System.out.print(micro.getName());
                System.out.print(" | ");
                System.out.print(micro.getAmount());
                // System.out.print(" | ");
                // System.out.print(micro.getAdditionDate());
                // System.out.print(" | ");
                // System.out.print(micro.getSelectedCategory());

            }
        }
        System.out.println("");
    }

    public void manageExpensesScene()
    {
        ExpenseDAO expDAO = new ExpenseDAO();

        //Get all user's expenses
        try {
            this.expenseList = (expDAO.getAll(-1)).get();
        } catch (Exception e) {
            System.out.println(e);
        }
        

        printList();
        
        Scanner sc = new Scanner(System.in);
        Expense curr_exp = new Expense();
        while(true)
        {
            System.out.println("Enter index number of the expense you want to see the details for. Enter 0 to add expense");
            String input_buffer = sc.nextLine();
            try {

                //Get the index that the user inputted
                int index = Integer.parseInt(input_buffer)-1;
                try 
                {
                    //Get the expense_id of the indexed expense
                    int id; 
                    id =  expenseList.get(index).getId();
                    //Fetch expense data from db
                    curr_exp = expDAO.get(id).get();
                    
                }
                //Handle out of bounds exception 
                catch (Exception e) 
                {
                    System.out.println("Invalid index");    
                    System.out.println(e);    
                }
                break;
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
            
        }
        sc.close();
        this.printExpenseDetails(curr_exp);
    }

}
