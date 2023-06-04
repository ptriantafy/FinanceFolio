package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

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
        String query = "SELECT cost FROM expense WHERE expense_id = ? ;";
        

        //Try to query the database
        try(PreparedStatement stmt = con.prepareStatement(query)) 
        {
            
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            
            //Get row if exists 
            if(rs.next())
            {
                float cost = rs.getFloat("cost");
                result.setAmount(cost); 
                System.out.println(cost);
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
        String query = "SELECT * FROM expense;";

        //Try to query the database
        try(PreparedStatement stmt = con.prepareStatement(query)) 
        {

            //stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            //Get row if exists 
            while(rs.next())
            {
                Expense temp_result = new Expense();
                temp_result.setId(rs.getInt("expense_id"));
                temp_result.setAmount(rs.getDouble("cost")); 
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
        String query = "INSERT expense(cost, description) cost =? , description = ? WHERE expense_id = ?;";

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
