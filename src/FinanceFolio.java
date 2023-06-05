
import com.financefolio.dao.ExpenseDAO;
import com.financefolio.expensemanagement.*;
import java.sql.Connection;

import java.util.*;


public class FinanceFolio
{
    public static void main(String[] args) 
    {
        ExpenseDAO expDAO = new ExpenseDAO();
        List<Expense> exp = new ArrayList<Expense>();
        try{
            exp = expDAO.getAll(1).get();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i=0; i<exp.size(); i++)
        {
            System.out.print(exp.get(i).getAmount()+" | ");
            System.out.println(exp.get(i).getAddition_date());
        }
        
    }

}
