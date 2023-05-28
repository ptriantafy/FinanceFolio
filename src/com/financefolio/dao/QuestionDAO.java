package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Question> get(int request_id) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM question WHERE request_id = ?;");
		statement.setInt(1, request_id);
		ResultSet rs = statement.executeQuery();
		Question result = new Question(rs.getString("title"),rs.getInt("question_id"), 
                                        rs.getString("body"), rs.getDate("cdate"),rs.getInt("author_id"));
        result.setUpvotes(rs.getInt("upvotes"));
        result.setDownvotes(rs.getInt("downvotes"));
		con.close();
		return Optional.ofNullable(result);
    }

    @Override 
    public Optional<List<Question>> getAll(int request_id) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM question WHERE receiver_id = ?;");
		statement.setInt(1, request_id);
		ResultSet rs = statement.executeQuery();
		List<Question> result = new ArrayList<Question>();
		while(rs.next()) {
			Question tempresult = new Question(rs.getString("title"),rs.getInt("question_id"), 
                                        rs.getString("body"), rs.getDate("cdate"),rs.getInt("author_id"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    public void save(Question que, String arg[]) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO question(title, body, "
				+ "author_id) VALUES (?, ?, ?);");
		statement.setString(1, que.getTitle());
		statement.setString(2, que.getBody());
		statement.setInt(3, que.getAuthorId());
		statement.executeQuery();
		ResultSet last_id = statement.getGeneratedKeys();
		con.close();
		que.setRequestId(last_id.getInt(1));
    }
}
