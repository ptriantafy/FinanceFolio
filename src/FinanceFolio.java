
import com.financefolio.dao.ExpenseDAO;
import com.financefolio.expensemanagement.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;


public class FinanceFolio
{
    
    public static void main(String[] args) 
    {

        ExpenseManagement mng = new ExpenseManagement();

        // Bill bl = new Bill("Mypower", 146.5);

        ExpenseDAO xDao = new ExpenseDAO();

        Miscellaneous misc = new Miscellaneous("trip", 0);


        List<Expense> micros = new ArrayList<Expense>();

        Expense gas = new Expense();
        gas.init(56, "", "gas", "");

        micros.add(gas);
        
        Expense coffee = new Expense();
        coffee.init(10,"","coffee","");
        micros.add(coffee);


        misc.appendEnMass(micros);
        // bl.setOwed(15.3);
        // bl.setType("power");
        // bl.setDateFrom(Date.valueOf("2023-5-3"));
        // bl.setDateTo(Date.valueOf("2023-3-4"));

        mng.printExpenseDetails(misc);

        try {
            xDao.save(misc);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        // ExpenseManagement expMngmnt = new ExpenseManagement();
        // expMngmnt.manageExpensesScene();
        
    }

}