
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
            
            exp.get(2).setAmount(19.32);
            expDAO.update(exp.get(2),null);

            expDAO.delete(exp.get(0));

            exp = expDAO.getAll(1).get();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i=0; i<exp.size(); i++)
        {
            System.out.println(exp.get(i).getAmount());
        }
        
    }

}
