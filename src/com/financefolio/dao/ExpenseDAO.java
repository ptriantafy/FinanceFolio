package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import com.financefolio.addexpenses.*;

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
    public Optional<Expense> get(int id ) throws SQLException, Exception 
    {
        return null;
    }

    @Override
    public Optional<List<Expense>> getAll (int id) throws SQLException, Exception
    {
        return null;
    }

    @Override 
    public void save (Expense t) throws SQLException
    {
        
    }

    @Override
    public void update(Expense t, String[] params) throws SQLException
    {

    }

    @Override
    public void delete(Expense t) throws SQLException
    {
            
    }



    
}
