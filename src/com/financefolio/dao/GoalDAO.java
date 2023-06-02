package com.financefolio.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.StartElement;

import java.sql.*;

import com.financefolio.goals.*;

public class GoalDAO implements DAO<Goal>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String username;
    private String password;

    public GoalDAO()
    {
        this.username = "root";
        this.password = "Dfg5c12af49gr58";
    }

    public Connection connect() throws Exception
    {
        //Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(db_url, username, password);

        System.out.println("Connection established");

        return con;
    }

    @Override
    public Optional<Goal> get(int goal_id) throws Exception{
        // Connection con = this.connect();
		// PreparedStatement statement = con.prepareStatement("SELECT * FROM question WHERE question_id = ?;");
		// statement.setInt(1, question_id);
		// ResultSet rs = statement.executeQuery();
		// Question result = new Question(rs.getInt("question_id"), rs.getString("title"), 
        //                                 rs.getString("body"), rs.getDate("cdate"),rs.getInt("author_id"));
        // result.setUpvotes(rs.getInt("upvotes"));
        // result.setDownvotes(rs.getInt("downvotes"));
        // result.setRating();
		// con.close();
		return null;
    }

    @Override 
    public Optional<List<Goal>> getAll(int dummy) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Goal;");
		// statement.setInt(1, goal_id);
		ResultSet rs = statement.executeQuery();
		List<Goal> result = new ArrayList<Goal>();
		while(rs.next()) {
			Goal tempresult = new Goal(rs.getInt("goal_id"), 
                                       rs.getInt("owner_id"), 
                                       rs.getString("name"), 
                                       rs.getString("state"),
                                       rs.getBoolean("shared"),
                                       rs.getLong("time_duration"),
                                       rs.getFloat("money_to_spend"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }


    public void save(Goal goal, String arg[]) throws Exception { 
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO goals(owner_id,name,state," + 
                                            "shared,time_duration,money_to_spend,difficulty," +
                                            "reward) VALUES (?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, goal.getOwnerId());
            statement.setString(2, goal.getName());
            statement.setString(3, goal.getState());
            statement.setBoolean(4, goal.isShared());
            statement.setLong(5, goal.getTimeDuration());
            statement.setFloat(6, goal.getMoneyToSpend());
            statement.setInt(7, goal.getDifficulty());
            statement.setInt(8, goal.getReward());
            
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
}
