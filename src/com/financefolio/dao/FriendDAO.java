package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.financefolio.social.Friend;

public class FriendDAO implements DAO<Friend> {

	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public FriendDAO()
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
	
//	fetch friend list of given member_id
	@Override
	public Optional<Friend> get(int id) throws SQLException, Exception {
//		not implemented yet
		return null;
	}

//	fetch friend list of given member_id
	@Override
	public Optional<List<Friend>> getAll(int id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM friendships WHERE member1_id = ? OR member2_id = ?;");
		statement.setInt(1, id);
		statement.setInt(2, id);
		ResultSet rs = statement.executeQuery();
		List<Friend> result = new ArrayList<>();
		while(rs.next()) {
			Friend tempresult;
			if(rs.getInt("member1_id") == id) {  // looks ugly but works
//				Member requesting friends list is member1 in database
				tempresult = new Friend(rs.getInt("member2_id"), rs.getInt("sharing_level_to2"), rs.getInt("chat_id"), rs.getDate("friends_since"));
			}
			else {
//				Member requesting friends list is member2 in database
				tempresult = new Friend(rs.getInt("member1_id"), rs.getInt("sharing_level_to1"), rs.getInt("chat_id"), rs.getDate("friends_since"));
			}
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	insert a new friendship; requires args[0]=member_id where member is the one accepting a friend request
//	requires args[1] = friendRequest.getSenderSharingLevel
	@Override
	public void save(Friend t, String args[]) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO chat VALUES();", Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate();
		ResultSet newChatId = statement.getGeneratedKeys();
//		member1 is FriendRequest sender
	    int chatId = 0;
		if (newChatId.next()) {
	        chatId = newChatId.getInt(1);
	    }
		statement = con.prepareStatement("INSERT INTO friendships(member1_id, member2_id, "
				+ " friends_since, chat_id, sharing_level_to2, sharing_level_to1) VALUES (?, ?, ?, ?, ?, ?);");
		statement.setInt(1, t.getId());
		statement.setInt(2, Integer.parseInt(Objects.requireNonNull(args[0], "ID of member cannot be null")));
		statement.setDate(3, t.getFriendsSince());
		statement.setInt(4, chatId);
		statement.setInt(5, Integer.parseInt(Objects.requireNonNull(args[1], "Sharing Level from friend cannot be null")));
		statement.setInt(6, t.getSharingLevel());
		t.getConversation().setChat_id(chatId);
		statement.executeUpdate();
		con.close();
//		System.out.println(chatId);
	}

//	edit existing friendship
	@Override
	public void update(Friend t) throws SQLException, Exception {
//		not implemented yet
	}

//	delete friendship
	@Override
	public void delete(Friend t) throws SQLException, Exception {
		Connection con = this.connect();
//		only chat_id is unique in database
		PreparedStatement statement = con.prepareStatement("DELETE FROM friendships WHERE chat_id = ?;");
		statement.setInt(1, t.getConversation().getChat_id());
		statement.executeUpdate();
		con.close();
	}



}
