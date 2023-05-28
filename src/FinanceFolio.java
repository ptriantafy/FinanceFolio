
import com.financefolio.dao.ExpenseDAO;
import java.sql.Connection;
public class FinanceFolio
{
    public static void main(String[] args) 
    {
        ExpenseDAO expDAO = new ExpenseDAO();
        try{
            Connection con = expDAO.connect();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }

}
