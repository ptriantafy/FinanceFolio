
import com.financefolio.dao.ExpenseDAO;
import com.financefolio.expensemanagement.*;
import java.sql.Connection;
import com.financefolio.expensemanagement.*;
import java.util.*;


public class FinanceFolio
{
    
    public static void main(String[] args) 
    {
        ExpenseManagement expMngmnt = new ExpenseManagement();
        expMngmnt.manageExpensesScene();
        
    }

}