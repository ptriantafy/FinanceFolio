package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
        if(result.getCategory().equals("Miscellaneous"))
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

        else if(result.getCategory().equals("Bill"))
        {
            Bill bill = new Bill(result.getName(), result.getAmount());

            query = "SELECT * FROM Bill WHERE bill_id = ? ;";

            try(PreparedStatement stmt = con.prepareStatement(query))
            {
                stmt.setInt(1,id);
            
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    bill.setType(rs.getString("bill_type"));
                    bill.setOwed(rs.getDouble("owed"));
                    bill.setDateFrom(rs.getDate("dateFrom"));
                    bill.setDateTo(rs.getDate("dateTo"));
                    
                    //cast bill as expense
                    result = (Expense)bill;
                }

            } 
            catch (Exception e) {
                // TODO: handle exception
            }

        }
        else if(result.getCategory().equals("Subscription"))
        {
            Subscription sub = new Subscription(result.getName(), result.getAmount());
            query = "SELECT * FROM Subscription WHERE subscription_id = ? ;";



            try(PreparedStatement stmt = con.prepareStatement(query))
            {
                stmt.setInt(1,id);
            
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
           
                    sub.setNextBillingDate(rs.getDate("next_billing_date"));
                    //cast sub as expense
                    result = (Expense)sub;
                }

            } 
            catch (Exception e) {
                // TODO: handle exception
            }

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
    public void save (Expense t, String arg[]) throws SQLException, Exception
    {
        //Create connection object
        Connection con = this.connect();
        
        //DB query
        String query;

        //Micro expense parent id 
        int p_id = 0;
        
        if(t instanceof Bill)
        {

            query = "INSERT INTO bill ( bill_type, owed, cost, dateFrom, dateTo ) VALUES (?, ?, ?, ?, ?);";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {
                stmt.setString(1,((Bill)t).getType());
                stmt.setDouble(2, ((Bill)t).getOwed());
                stmt.setDouble(3,((Bill)t).getAmount());
                stmt.setDate(4, ((Bill)t).getDateFrom());
                stmt.setDate(5, ((Bill)t).getDateTo());


                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }
        }
        else if( t instanceof Subscription)
        {
        	query = "INSERT INTO subscription(sub_name, cost, next_billing_date) VALUES (? , ?, ?);";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {

                stmt.setString(1, ((Subscription)t).getName());
                stmt.setDouble(2, ((Subscription)t).getAmount());
                stmt.setDate(3, ((Subscription)t).getNextBillingDate());

                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }
        }
        else if(t instanceof Miscellaneous)
        {

            //Create miscellaneous expense
        	query = "INSERT INTO miscellaneous(misc_exp_name) VALUES (?);";
            try(PreparedStatement stmt = con.prepareStatement(query)) 
            {

                stmt.setString(1,((Miscellaneous)t).getName());

                stmt.executeUpdate();
            } 
            catch (Exception e) 
            {
            	System.out.println(e);
            }

            //Get the id that the db gave to the added misc expense
            query = "SELECT MAX(misc_id) FROM miscellaneous;";

            try(Statement stmt = con.createStatement()) 
            {   
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next())
                {
                    p_id = rs.getInt("MAX(misc_id)");
                }
            } catch (Exception e) {
                
            }

            System.out.println(p_id);
            //Insert all of micro expenses
            for(int i =0; i < ((Miscellaneous)t).getNumberOfMicroExpenses(); i++)
            {
                Expense micro = new Expense();
                micro = ((Miscellaneous)t).getMicroExpense(i);

                query = "INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (?, ?, ?);";

                try(PreparedStatement stmt = con.prepareStatement(query)) 
                {
    
                    stmt.setInt(1, p_id);
                    stmt.setString(2,t.getName());
                    stmt.setDouble(3, micro.getAmount());
    
                    stmt.executeUpdate();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }

                
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
