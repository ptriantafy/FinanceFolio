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

import com.financefolio.points.Points;
import com.financefolio.user.Member;

public class PointsDAO implements DAO<Points>{
	private String usrname;
	private String password;
	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	
	//constructor
	public PointsDAO()
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
	
	@Override
	public Optional<Points> get(int point_id) throws SQLException, Exception {
		try (Connection con = this.connect();
		         PreparedStatement statement = con.prepareStatement("SELECT * FROM points WHERE point_id = ?;")) {
		        statement.setInt(1, point_id);
		        try (ResultSet rs = statement.executeQuery()) {
		            if (rs.next()) {
		                Points result = new Points(rs.getInt("point_id"), rs.getInt("amount"), rs.getTimestamp("timestamp"), rs.getString("reason"));
		                return Optional.of(result);
		            }
		        }
		    }
		return Optional.empty();
	}

	@Override
	public Optional<List<Points>> getAll(int member_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM points WHERE member_id = ?");
		 statement.setInt(1, member_id);
		ResultSet rs = statement.executeQuery();
		List<Points> result = new ArrayList<>();
		while(rs.next()) {
			Points tempresult = new Points(rs.getInt("point_id"), rs.getInt("amount"), rs.getTimestamp("timestamp"), rs.getString("reason"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	requires args[0] = member_id
	@Override
	public void save(Points t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement= con.prepareStatement("INSERT INTO points (member_id, "
				+ " amount, reason, timestamp) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, Integer.parseInt(Objects.requireNonNull(args[0], "ID of member cannot be null")));
		statement.setInt(2, t.getAmount());
		statement.setString(3, t.getReason());
		statement.setTimestamp(4, t.getTimestamp());
		statement.executeUpdate();
		ResultSet newPointId = statement.getGeneratedKeys();
		int pointId = 0;
		if (newPointId.next()) {
			pointId = newPointId.getInt(1);
		}
		t.setId(pointId);
		con.close();
	}

	@Override
	public void update(Points t) throws SQLException, Exception {
//		unimplemented
	}

	@Override
	public void delete(Points t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM points WHERE point_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeUpdate();
		con.close();
	}

}
