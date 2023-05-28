package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class ExpenseDAO {
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
    
}
