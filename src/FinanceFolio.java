import java.util.ArrayList;
import java.util.List;

import com.financefolio.expensemanagement.*;

import com.financefolio.dao.ExpenseDAO;


public class FinanceFolio
{
   
    public static void main(String[] args) 
    {
        ExpenseDAO xDao = new ExpenseDAO();
        Expense exp = new Expense();

        try {
            exp = xDao.get(2).get();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(((Miscellaneous)exp).getNumberOfMicroExpenses());
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
        // List<Expense> micro_exp = new ArrayList<Expense>();
        // Miscellaneous misc = new Miscellaneous(null, 0);
        //misc.appendEnMass(micro_exp);


        ExpenseManagement manage = new ExpenseManagement();
        manage.manageExpensesScene();
        
    }

}
