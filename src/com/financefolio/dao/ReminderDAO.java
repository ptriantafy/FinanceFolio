package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import com.financefolio.calendar.Reminder;
import com.mysql.cj.protocol.Resultset;

public class ReminderDAO implements DAO<Reminder>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String username;
    private String password;

    public ReminderDAO()
    {
        this.username = "root";
        this.password = "";
    }

    public Connection connect() throws Exception
    {
        //Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection with database
        Connection con = DriverManager.getConnection(db_url, username, password);

        System.out.println("Connection established");

        return con;
    }

    @Override
    public Optional<Reminder> get(int reminder_id) throws Exception{
        Connection con = this.connect();
        //SQL statement to be executed
		PreparedStatement statement = con.prepareStatement("SELECT * FROM reminder WHERE reminder_id = ?;");
        //value of ?
		statement.setInt(1, reminder_id);
        //Execute query
		ResultSet rs = statement.executeQuery();
        //Retrieve comment details from database and make new comment object
		Reminder result = new Reminder(rs.getInt("reminder_id"),rs.getString("body"),rs.getString("DayNotifyBefore"),rs.getString("HourNotifyBefore"),rs.getString("payment_frequency"),rs.getInt("frequency"),rs.getString("date"));
		return Optional.ofNullable(result);
    }

    @Override 
    public Optional<List<Reminder>> getAll(int calendar_id) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM reminder where calendar_id = ?;");
		statement.setInt(1, calendar_id);
		ResultSet rs = statement.executeQuery();
        //create new list of comments to store result
		List<Reminder> result = new ArrayList<Reminder>();    
        //while rs has an entry keep looping
		while(rs.next()) {
			Reminder tempresult = new Reminder(rs.getInt("reminder_id"),rs.getString("body"),rs.getString("DayNotifyBefore"),rs.getString("HourNotifyBefore"),rs.getString("payment_frequency"),rs.getInt("frequency"),rs.getString("date"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    public void save(Reminder r, String arg[]) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO remider(reminder_id, body, day_notify_before, hour_notify_before, payment_frequency, frequency, date) VALUES (?, ?, ?, ?, ?, ?, CURDATE());");
            statement.setInt(1, r.getReminder_id());
            statement.setString(2, r.getBody());
            statement.setString(3, r.getDayNotifyBefore());
            statement.setString(4, r.getHourNotifyBefore());
            statement.setString(5, r.getPayment_frequency());
	    statement.setInt(6, r.getFrequency());
            statement.executeUpdate();
            lastId = statement.getGeneratedKeys();
            if (lastId.next()) {
                int reminder_id = lastId.getInt(2);
                r.setReminder_id(reminder_id);
            }
        } finally {
            if (lastId != null) {
                lastId.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    @Override
    public void update(Reminder r) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE reminder SET body = ?, DayNotidyBefore = ?, HourNotifyBefore = ?, payment_frequency = ?, frequency = ?;");
		statement.setString(1, r.getBody());
		statement.setString(2, r.getDayNotifyBefore());
		statement.setString(3, r.getHourNotifyBefore());
		statement.setString(4, r.getPayment_frequency());
		statement.setInt(5, r.getFrequency());
		statement.executeUpdate();
		con.close();
    }

    @Override
    public void delete (Reminder r) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM reminder WHERE reminder_id = ?;");
		statement.setInt(1, r.getReminder_id());
		statement.executeQuery();
		con.close();
    }
}