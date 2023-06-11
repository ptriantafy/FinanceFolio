package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import com.financefolio.goals.*;

public class GoalDAO implements DAO<Goal>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String usrname;
    private String password;

    public GoalDAO()
    {
        this.usrname = "root";
        this.password = "Dfg5c12af49gr58";
    }

    public Connection connect() throws Exception
    {
        //Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(db_url, usrname, password);

        System.out.println("Connection established");

        return con;
    }

    @Override
    public Optional<Goal> get(int goal_id) throws Exception{
		return null;
    }

    @Override
    public Optional<List<Goal>> getAll(int ownerId) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM goals where owner_id = ?;");
        statement.setInt(1, ownerId);
		ResultSet rs = statement.executeQuery();
		List<Goal> result = new ArrayList<Goal>();
		while(rs.next()) {
			Goal tempresult = new Goal(rs.getInt("goal_id"), 
                                       rs.getInt("owner_id"), 
                                       rs.getString("name"), 
                                       rs.getBoolean("shared"),
                                       rs.getLong("time_duration"),
                                       rs.getFloat("money_to_spend"));
            tempresult.setState(rs.getString("state"));
            tempresult.setReward(rs.getInt("reward"));
            tempresult.setDifficulty(rs.getInt("difficulty"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    public void save(Goal goal, String arg[]) throws Exception { 
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO goals(owner_id,name," + 
                                            "shared,time_duration,money_to_spend,difficulty," +
                                            "reward) VALUES (?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, goal.getOwnerId());
            statement.setString(2, goal.getName());
            statement.setBoolean(3, goal.isShared());
            statement.setLong(4, goal.getTimeDuration());
            statement.setFloat(5, goal.getMoneyToSpend());
            statement.setInt(6, goal.getDifficulty());
            statement.setInt(7, goal.getReward());
            
            statement.executeUpdate();
            
            lastId = statement.getGeneratedKeys();
            if (lastId.next()) {
                int goalId = lastId.getInt(1);
                goal.setGoalId(goalId);
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
    public void update(Goal goal, String arg[]) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("UPDATE goals SET name = ?, state = ?, shared = ?, time_duration = ?, " +
                    "money_to_spend = ?, difficulty = ?, reward = ? WHERE goal_id = ?;");
            
            statement.setString(1, goal.getName());
            statement.setString(2, goal.getState());
            statement.setBoolean(3, goal.isShared());
            statement.setLong(4, goal.getTimeDuration());
            statement.setFloat(5, goal.getMoneyToSpend());
            statement.setInt(6, goal.getDifficulty());
            statement.setInt(7, goal.getReward());
            statement.setInt(8, goal.getGoalId());
            
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            
            if (con != null) {
                con.close();
            }
        }
    }

    @Override 
    public void delete(Goal goal) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("DELETE FROM goals WHERE goal_id = ?;");
            statement.setInt(1, goal.getGoalId());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            
            if (con != null) {
                con.close();
            }
        }
    }
    
}
