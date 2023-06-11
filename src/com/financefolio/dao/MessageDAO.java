package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.financefolio.social.chat.Message;

public class MessageDAO implements DAO<Message> {
	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public MessageDAO()
	{
		this.usrname = "FinanceFolioJava";
		this.password = "FinFolJavPass";
	}
	
	public Connection connect() throws Exception
	{
		//Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//AttemptConnection
		Connection con = DriverManager.getConnection(
				db_url,usrname,password);
		
//		System.out.println("Connection Established Successfully!");
		return con;
	}
	
//	fetch a specific message given its id
	@Override
	public Optional<Message> get(int message_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM messages WHERE message_id= ?;");
		statement.setInt(1, message_id);
		ResultSet rs = statement.executeQuery();
		Message result = new Message(rs.getInt("message_id"), rs.getInt("sender_id"), rs.getInt("receiver_id"), rs.getString("body"), rs.getTimestamp("sent_on"), rs.getInt("chat_id"));
		con.close();
		return Optional.ofNullable(result);
	}
	
//  fetch all messages in a chat conversation given chat_id
	@Override
	public Optional<List<Message>> getAll(int chat_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM messages WHERE chat_id = ?;");
		statement.setInt(1, chat_id);
		ResultSet rs = statement.executeQuery();
		List<Message> result = new ArrayList<>();
		while(rs.next()) {
			Message tempresult = new Message(rs.getInt("message_id"), rs.getInt("sender_id"), 
														rs.getInt("receiver_id"), rs.getString("body"), rs.getTimestamp("sent_on"), rs.getInt("chat_id"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	insert a new message
	@Override
	public void save(Message t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO messages(sender_id, receiver_id, "
				+ "body, sent_on, chat_id) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, t.getSender_id());
		statement.setInt(2, t.getReceiver_id());
		statement.setString(3, t.getBody());
		statement.setTimestamp(4, t.getSentOn());
		statement.setInt(5, t.getChat_id());
		statement.executeUpdate();
		ResultSet last_id = statement.getGeneratedKeys();
	    int messId = 0;
		if (last_id.next()) {
	        messId = last_id.getInt(1);
	    }
		t.setId(messId);		
		con.close();
	}

//	edit existing message
	@Override
	public void update(Message t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE messages SET sender_id = ?, receiver_id = ?, "
				+ "body = ?, sent_on = ?, chat_id = ? WHERE message_id= ?;");
		statement.setInt(1, t.getSender_id());
		statement.setInt(2, t.getReceiver_id());
		statement.setString(3, t.getBody());
		statement.setTimestamp(4, t.getSentOn());
		statement.setInt(5, t.getChat_id());
		statement.setInt(6, t.getId());
		statement.executeUpdate();
		con.close();
	}

	
//	delete existing chat
	@Override
	public void delete(Message t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM messages WHERE chat_id = ?;");
		statement.setInt(1, t.getChat_id());
		statement.executeUpdate();
		statement = con.prepareStatement("DELETE FROM chat WHERE chat_id = ?;");
		statement.setInt(1, t.getChat_id());
		statement.executeUpdate();
		con.close();
	}

}
