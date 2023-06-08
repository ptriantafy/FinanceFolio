package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;



import com.financefolio.expensemanagement.*;

public class ExpenseDAO implements DAO<Expense>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String username = "FinanceFolioDB";
    private String passsword = "softkings";


    public Connection connect() throws Exception
    {
        //load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //attempt connection
        Connection con = DriverManager.getConnection(db_url, username, passsword);  
        System.out.println("Connection established");
        
        return con;
        
    }





    @Override
    public Optional<Expense> get(int id) throws SQLException, Exception 
    {
        //Create Expense object
        Expense result = new Expense();
        
        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query = "SELECT * FROM expense WHERE expense_id = ? ;";

        //Expense type
        String expense_type = "";


        //Search object in the expense table and find its attributes
        try(PreparedStatement stmt = con.prepareStatement(query))
        {
            stmt.setInt(1,id);
        
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                result.setName(rs.getString("expense_name"));
                result.setCategory(rs.getString("expense_category"));
                result.setId(rs.getInt("expense_id"));
                result.setAmount(rs.getDouble("cost")); 
                result.setAdditionDate(rs.getDate("addition_date"));
             }
        } 
        catch (Exception e) {
            System.out.println(e);
        }


        //Based on the type of the expense retrieved, fetch from the corresonding table
        if(result.getSelectedCategory().equals("Miscellaneous"))
        {
            Miscellaneous misc = new Miscellaneous(result.getName(),result.getAmount());
            List<Expense> micros = new ArrayList<Expense>();

            //Query the misc table
            query = "SELECT * FROM Miscellaneous WHERE misc_id = ? ;";


            try(PreparedStatement stmt = con.prepareStatement(query))
            {
                stmt.setInt(1,id);
            
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {

                    //fetch misc expense's micro expenses
                    micros = this.getAll(2).get();
                    misc.appendEnMass(micros);
                    
                    //cast misc as expense
                    result = (Expense)misc;
                }

            } 
            catch (Exception e) {
                // TODO: handle exception
            }

        }

        else if(result.getSelectedCategory().equals("Bill"))
        {
            
        }

        // //Query the database

        // try(PreparedStatement stmt = con.prepareStatement(query))
        // {
        //     stmt.setInt(1,id);
            
        //     ResultSet rs = stmt.executeQuery();
        //     if(rs.next())
        //     {
        //         result.setCategory(rs.getString("expense_type"));
        //         result.setId(rs.getInt("expense_id"));
        //         result.setAmount(rs.getDouble("cost")); 
        //         result.setAdditionDate(rs.getDate("addition_date"));
        //     }

        //     if(result.getSelectedCategory().equals("Bill"))
        //     {
        //         query = "SELECT * FROM Bill WHERE bill_id = ? ;";

        //     }
        //     else if(result.getSelectedCategory().equals("Subscription"))
        //     {
        //         query = "SELECT * FROM Subscription WHERE subscription_id = ? ;";

        //     }
        //     else if(result.getSelectedCategory().equals("Miscellaneous"))
        //     {
        //         System.out.println("Check");
        //         query = "SELECT * FROM Miscellaneous WHERE misc_id = ? ;";

        //     }

            
        // } 
        // catch (Exception e)
        // {
        //     //System.out.println(e);
        // }

        
        // //Try to query the database
        // try(PreparedStatement stmt = con.prepareStatement(query)) 
        // {
            
        //     stmt.setInt(1,id);
            
        //     ResultSet rs = stmt.executeQuery();
            
        //     //Get row if exists 
        //     if(rs.next())
        //     {
                
            
        //         if(result.getSelectedCategory().equals("Bill"))
        //         {
        //             Bill bill = (Bill) result;
        //             bill.setType(rs.getString("bill_type"));
        //             bill.setOwed(rs.getDouble("owed"));
        //             bill.setDateFrom(rs.getDate("dateFrom"));
        //             bill.setDateTo(rs.getDate("dateTo"));
        //             //result = bill;
        //         }
        //         else if(result.getSelectedCategory().equals("Miscellaneous"))
        //         {
        //             Miscellaneous misc = (Miscellaneous) result;
        //             List<Expense> micro_expenses = new ArrayList<Expense>();
        //             micro_expenses = this.getAll(id).get();
        //             misc.appendEnMass(micro_expenses);
        //             //result = misc;
        //         }
        //         else if(result.getSelectedCategory().equals("Subscription"))
        //         {
        //             Subscription sub = (Subscription) result;
        //             sub.setNextBillingDate(rs.getDate("next_billing_date"));
        //             //result = sub;
        //         }

        //     }
        // } 
        // catch (Exception e) 
        // {
        //     System.out.println(e);
        // }

        
        //Terminate connection
        con.close();


        return Optional.ofNullable(result);
    }
    
    @Override
    public Optional<List<Expense>> getAll (int id) throws SQLException, Exception
    {
        //Create Expense object
        List<Expense> result = new ArrayList<Expense>();

        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query;
        if(id < 0)
        {
            query = "SELECT * FROM expense;";
            //Try to query the database
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {
                
                ResultSet rs = stmt.executeQuery();
    
                //Get row if exists 
                while(rs.next())
                {
                    Expense temp_result = new Expense();
                    temp_result.setName(rs.getString("expense_name"));
                    temp_result.setCategory(rs.getString("expense_category"));
                    temp_result.setId(rs.getInt("expense_id"));
                    temp_result.setAmount(rs.getDouble("cost")); 
                    temp_result.setAdditionDate(rs.getDate("addition_date"));
    
                    result.add(temp_result);
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else
        {
            query = "SELECT * FROM misc_micro_expenses WHERE parent_expense_id = ?;";
            //Try to query the database
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {
    
                
                stmt.setInt(1,id);
                
                ResultSet rs = stmt.executeQuery();
    
                //Get row if exists 
                while(rs.next())
                {
                    Expense temp_result = new Expense();
                    temp_result.setId(rs.getInt("micro_expense_id"));
                    temp_result.setAmount(rs.getDouble("cost")); 
                    temp_result.setName(rs.getString("micro_expense_name")); 
    
                    result.add(temp_result);
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);

            }
        }

        
        con.close();
        return Optional.ofNullable(result);
    }

    @Override 
    public void save (Expense t, String [] args) throws SQLException, Exception
    {
        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query;
        
        if(t instanceof Bill)
        {
            
            query = "INSERT INTO ( type, owed, cost, dateFrom, dateTo ) VALUES type = ?, owed = ?, cost = ?, dateFrom = ?, dateTo = ?;";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {
                stmt.setString(1,((Bill)t).getType());
                stmt.setDouble(2, ((Bill)t).getOwed());
                stmt.setDouble(3,((Bill)t).getAmount());
                stmt.setDate(4, ((Bill)t).getDateFrom());
                stmt.setDate(4, ((Bill)t).getDateTo());


                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }
        }
        else if( t instanceof Subscription)
        {
        	query = "INSERT INTO subscription(cost, next_billing_date) VALUES cost =? , next_billing_date = ?;";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {

                stmt.setDouble(1, ((Subscription)t).getAmount());
                stmt.setDate(2, ((Subscription)t).getNextBillingDate());

                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }
        }
        else if(t instanceof Miscellaneous)
        {
        	query = "INSERT INTO miscellaneous(cost, description) VALUES cost =? , description = ?;";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {

                stmt.setDouble(1, t.getAmount());
                stmt.setString(2,t.getDescription());

                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }
        }


        

        con.close();
    }

    @Override
    public void update(Expense t, String[] params) throws SQLException, Exception
    {
         //Create connection object
         Connection con = this.connect();
        
         //DB query
         String query = "UPDATE expense SET cost =? , description = ? WHERE expense_id = ?;";
 
         try(PreparedStatement stmt = con.prepareStatement(query)) 
         {
 
            stmt.setDouble(1, t.getAmount());
            stmt.setString(2,t.getDescription());
            stmt.setInt(3,t.getId());

            stmt.executeUpdate();
         } 
         catch (Exception e) 
         {
             System.out.println(e);
         }
 
         con.close();
    }

    @Override
    public void delete(Expense t) throws SQLException, Exception
    {
        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query = "DELETE FROM expense WHERE expense_id = ?;";

        try(PreparedStatement stmt = con.prepareStatement(query)) 
        {

            stmt.setInt(1,t.getId());

            stmt.executeUpdate();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        con.close();
    }



    
}
