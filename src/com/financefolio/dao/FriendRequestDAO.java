package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		PreparedStatement statement = con.prepareStatement("SELECT * FROM FriendRequest WHERE request_id = ?");
		statement.setInt(1, request_id);
		ResultSet rs = statement.executeQuery();
		FriendRequest result = new FriendRequest(rs.getInt("request_id"), rs.getInt("sender_id"), 
													rs.getInt("receiver_id"), rs.getTimestamp("sent_on"));
		return Optional.ofNullable(result);
	}

	@Override
	public Optional<List<FriendRequest>> getAll(int receiver_id) throws Exception{
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM FriendRequest WHERE receiver_id = ?");
		statement.setInt(1, receiver_id);
		ResultSet rs = statement.executeQuery();
		List<FriendRequest> result = new ArrayList<>();
		while(rs.next()) {
			FriendRequest tempresult = new FriendRequest(rs.getInt("request_id"), rs.getInt("sender_id"), 
														rs.getInt("receiver_id"), rs.getTimestamp("sent_on"));
			result.add(tempresult);
		}
		return Optional.ofNullable(result);
	}
	@Override
	public void save(FriendRequest t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FriendRequest t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FriendRequest t) {
		// TODO Auto-generated method stub
		
	}


}
