package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.Date;


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
    public Optional<Expense> get(int id, String[] params ) throws SQLException, Exception 
    {
        //Create Expense object
        Expense result = new Expense();
        
        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query = "SELECT * FROM expense WHERE expense_id = ? ;";
        if(params[0] == "Bill")
        {
            query = "SELECT * FROM Bill WHERE expense_id = ? ;";
        }
        else if(params[0] == "Subscription")
        {

        }
        else if(params[0] == "Miscellaneous")
        {

        }
        else
        {
            query = "SELECT * FROM expense WHERE expense_id = ? ;";
        }

    

        //Try to query the database
        try(PreparedStatement stmt = con.prepareStatement(query)) 
        {
            
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            
            //Get row if exists 
            if(rs.next())
            {
                result.setCategory(rs.getString("expense_type"));
                result.setId(rs.getInt("expense_id"));
                result.setAmount(rs.getDouble("cost")); 
                result.setAdditionDate(rs.getDate("addition_date"));

                if(params[0]=="Bill")
                {
                    ((Bill)result).setType(rs.getString("bill_type"));
                    ((Bill)result).getOwed(rs.getDouble("owed"));
                }

            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
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
        }
        else
        {
            query = "SELECT * FROM misc_micro_expenses WHERE parent_expense_id = ?;";
        }

        //Try to query the database
        try(PreparedStatement stmt = con.prepareStatement(query)) 
        {
            if(id > -1)
            {
                stmt.setInt(1,id);
            }

            ResultSet rs = stmt.executeQuery();

            //Get row if exists 
            while(rs.next())
            {
                Expense temp_result = new Expense();
                temp_result.setCategory(rs.getString("expense_type"));
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
