package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.financefolio.social.FriendRequest;

public class FriendRequestDAO implements DAO<FriendRequest> {

	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public FriendRequestDAO()
	{
		this.usrname = "FriendRequest";
		this.password = "FinFolFrReq";
	}
	
	public Connection connect() throws Exception
	{
		//Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//AttemptConnection
		Connection con = DriverManager.getConnection(
				db_url,usrname,password);
		
		System.out.println("Connection Established Successfully!");
		return con;
	}

	
	@Override
	public Optional<FriendRequest> get(int request_id) throws Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM friend_requests WHERE request_id = ?;");
		statement.setInt(1, request_id);
		ResultSet rs = statement.executeQuery();
		FriendRequest result = new FriendRequest(rs.getInt("request_id"), rs.getInt("sender_id"), 
													rs.getInt("receiver_id"),rs.getInt("sender_sharing_level"), rs.getTimestamp("sent_on"));
		con.close();
		return Optional.ofNullable(result);
	}

	@Override
	public Optional<List<FriendRequest>> getAll(int receiver_id) throws Exception{
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM friend_requests WHERE receiver_id = ?;");
		statement.setInt(1, receiver_id);
		ResultSet rs = statement.executeQuery();
		List<FriendRequest> result = new ArrayList<>();
		while(rs.next()) {
			FriendRequest tempresult = new FriendRequest(rs.getInt("request_id"), rs.getInt("sender_id"), 
														rs.getInt("receiver_id"), rs.getInt("sender_sharing_level"), rs.getTimestamp("sent_on"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}
	@Override
	public void save(FriendRequest t) throws Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO friend_requests(sender_id, receiver_id, "
				+ "sender_sharing_level, sent_on) VALUES (?, ?, ?, ?);");
		statement.setInt(1, t.getSenderId());
		statement.setInt(2, t.getReceiverId());
		statement.setInt(3, t.getSenderSharingLevel());
		statement.setTimestamp(4, t.getSentOn());
		statement.executeQuery();
		ResultSet last_id = statement.getGeneratedKeys();
		con.close();
		t.setRequestId(last_id.getInt(1));
	}

	@Override
	public void update(FriendRequest t) throws Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE friend_requests SET sender_id = ?, receiver_id = ?, "
				+ "sender_sharing_level = ? WHERE request_id = )");
		statement.setInt(1, t.getSenderId());
		statement.setInt(2, t.getReceiverId());
		statement.setInt(3, t.getSenderSharingLevel());
		statement.setInt(4, t.getRequestId());
		statement.executeQuery();
		con.close();
	}

	@Override
	public void delete(FriendRequest t) throws Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM friend_requests WHERE request_id = )");
		statement.setInt(1, t.getRequestId());
		statement.executeQuery();
		con.close();
	}


}
