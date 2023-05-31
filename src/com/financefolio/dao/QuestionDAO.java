package com.financefolio.dao;

// import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import com.financefolio.forum.Question;

public class QuestionDAO implements DAO<Question>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String username;
    private String password;

    public QuestionDAO()
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
    public Optional<Question> get(int question_id) throws Exception{
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
    public Optional<List<Question>> getAll(int dummy) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM question;");
		// statement.setInt(1, question_id);
		ResultSet rs = statement.executeQuery();
		List<Question> result = new ArrayList<Question>();
		while(rs.next()) {
			Question tempresult = new Question(rs.getInt("question_id"), rs.getString("title"), 
                                        rs.getString("body"), rs.getDate("cdate"),rs.getInt("author_id"));
            tempresult.setUpvotes(rs.getInt("upvotes"));
            tempresult.setDownvotes(rs.getInt("downvotes"));
            tempresult.setRating();
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    // public void save(Question que, String arg[]) throws Exception { 
    //     Connection con = this.connect();
	// 	PreparedStatement statement = con.prepareStatement("INSERT INTO question(title, body, "
	// 			+ "cdate, author_id) VALUES (?, ?, curdate(), ?);", Statement.RETURN_GENERATED_KEYS);
	// 	statement.setString(1, que.getTitle());
	// 	statement.setString(2, que.getBody());
	// 	statement.setInt(3, que.getAuthorId());
    //     statement.executeUpdate();
	// 	ResultSet last_id = statement.getGeneratedKeys();
	// 	que.setQuestionId(last_id.getInt(1));
    //     last_id.close();
    //     con.close();
    // }
    public void save(Question que, String arg[]) throws Exception { 
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO question(title, body, cdate, author_id) VALUES (?, ?, curdate(), ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, que.getTitle());
            statement.setString(2, que.getBody());
            statement.setInt(3, que.getAuthorId());
            
            statement.executeUpdate();
            
            lastId = statement.getGeneratedKeys();
            if (lastId.next()) {
                int questionId = lastId.getInt(1);
                que.setQuestionId(questionId);
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
    public void update(Question que) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE question SET title = ?, body = ?, "
				+ "upvotes = ?, downvotes = ? WHERE question_id = ?;");
		statement.setString(1, que.getTitle());
		statement.setString(2, que.getBody());
		statement.setInt(3, que.getUpvotes());
		statement.setInt(4, que.getDownvotes());
        statement.setInt(5, que.getQuestionId());
		statement.executeUpdate();
		con.close();
    }

    @Override 
    public void delete (Question que) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM question WHERE question_id = ?;");
		statement.setInt(1, que.getQuestionId());
		statement.executeQuery();
		con.close();
    }
}
