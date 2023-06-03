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

import com.financefolio.forum.Comment;
import com.mysql.cj.protocol.Resultset;

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
        //Connection with database
        Connection con = DriverManager.getConnection(db_url, username, password);

        System.out.println("Connection established");

        return con;
    }

    @Override
    public Optional<Comment> get(int comment_id) throws Exception{
        Connection con = this.connect();
        //SQL statement to be executed
		PreparedStatement statement = con.prepareStatement("SELECT * FROM comment WHERE comment_id = ?;");
        //value of ?
		statement.setInt(1, comment_id);
        //Execute query
		ResultSet rs = statement.executeQuery();
        //Retrieve comment details from database and make new comment object
		Comment result = new Comment(rs.getInt("question_id"),rs.getInt("comment_id"),rs.getString("body"),rs.getDate("cdate"),rs.getInt("author_id"));
        //set upvotes and downvotes based on default value of database
        result.setUpvotes(rs.getInt("upvotes"));
        result.setDownvotes(rs.getInt("downvotes"));
        //close connection with database
		con.close();
		return Optional.ofNullable(result);
    }

    @Override 
    public Optional<List<Comment>> getAll(int question_id) throws Exception {
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM comment where question_id = ?;");
		statement.setInt(1, question_id);
		ResultSet rs = statement.executeQuery();
        //create new list of comments to store result
		List<Comment> result = new ArrayList<Comment>();    
        //while rs has an entry keep looping
		while(rs.next()) {
			Comment tempresult = new Comment(rs.getInt("question_id"),rs.getInt("comment_id"), rs.getString("body"), 
                                        rs.getDate("cdate"),rs.getInt("author_id"));
            tempresult.setUpvotes(rs.getInt("upvotes"));
            tempresult.setDownvotes(rs.getInt("downvotes"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
    }

    @Override
    public void save(Comment com, String arg[]) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet lastId = null;
        try {
            con = this.connect();
            statement = con.prepareStatement("INSERT INTO comment(question_id, body, cdate, author_id) VALUES (?, ?, CURDATE(), ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, com.getQuestionId());
            statement.setString(2, com.getBody());
            statement.setInt(3, com.getAuthorId());
            statement.executeUpdate();
            lastId = statement.getGeneratedKeys();
            if (lastId.next()) {
                int commentId = lastId.getInt(2);
                com.setCommentId(commentId);
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
    public void update(Comment com) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE comment SET body = ?, "
				+ "upvotes = ?, downvotes = ? WHERE comment_id = ?;");
		statement.setString(1, com.getBody());
		statement.setInt(2, com.getUpvotes());
		statement.setInt(3, com.getDownvotes());
        statement.setInt(4, com.getCommentId());
		statement.executeUpdate();
		con.close();
    }

    @Override
    public void delete (Comment com) throws Exception{
        Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM comment WHERE comment_id = ?;");
		statement.setInt(1, com.getCommentId());
		statement.executeQuery();
		con.close();
    }
}
