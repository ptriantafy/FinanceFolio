package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.financefolio.forum.Comment;

public class CommentDAO implements DAO<Comment>{
    private String db_url = "jdbc:mysql://localhost:3306/financefolio";
    private String username;
    private String password;

    public CommentDAO()
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
    public Optional<Comment> get(int request_id) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM question WHERE request_id = ?;");
		statement.setInt(1, request_id);
		ResultSet rs = statement.executeQuery();
		Comment result = new Comment(rs.getInt("comment_id"),rs.getString("body"),rs.getDate("cdate"),rs.getInt("author_id"));
        result.setUpvotes(rs.getInt("upvotes"));
        result.setDownvotes(rs.getInt("downvotes"));
		con.close();
		return Optional.ofNullable(result);
    }

    @Override 
    public Optional<List<Comment>> getAll(int question_id) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM question WHERE question_id = ?;");
		statement.setInt(1, question_id);
		ResultSet rs = statement.executeQuery();
		List<Comment> result = new ArrayList<Comment>();
		while(rs.next()) {
			Comment tempresult = new Comment(rs.getInt("comment_id"), rs.getString("body"), 
                                        rs.getDate("cdate"),rs.getInt("author_id"));
            tempresult.setUpvotes(rs.getInt("upvotes"));
            tempresult.setDownvotes(rs.getInt("downvotes"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }
}
