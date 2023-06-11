package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import com.financefolio.goals.Achievement;

public class AchievementDAO implements DAO<Achievement>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String usrname;
    private String password;

    public AchievementDAO()
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
    public Optional<Achievement> get(int Achievement_id) throws Exception{
		return null;
    }

    @Override
    public Optional<List<Achievement>> getAll(int dummy) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM achievements;");
		ResultSet rs = statement.executeQuery();
		List<Achievement> result = new ArrayList<Achievement>();
		while(rs.next()) {
			Achievement tempresult = new Achievement(rs.getString("description"), 
                                       rs.getString("type"),
                                       rs.getInt("time_to_complete")); 
            tempresult.setState(rs.getString("state"));
            tempresult.setAchievementId(rs.getInt("achievement_id"));
            tempresult.setReward();
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    public void save(Achievement Achievement, String arg[]) throws Exception { 
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO Achievements(description," + 
                                            "reward, type, state, time_to_complete)" +
                                            "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Achievement.getDescription());
            statement.setInt(2, Achievement.getReward());
            statement.setString(3, Achievement.getType());
            statement.setString(4, Achievement.getState());
            statement.setInt(5, Achievement.getTimeToComplete());
            
            statement.executeUpdate();
            
            lastId = statement.getGeneratedKeys();
            if (lastId.next()) {
                int AchievementId = lastId.getInt(1);
                Achievement.setAchievementId(AchievementId);
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
    public void update(Achievement ach, String arg[]) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("UPDATE achievements SET state = ? WHERE achievement_id = ?;");
            
            statement.setString(1, ach.getState());
            statement.setInt(2, ach.getAchievementId());
            
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
    public void delete(Achievement ach) throws Exception {}
}
