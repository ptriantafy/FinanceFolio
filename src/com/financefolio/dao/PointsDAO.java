package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
		         PreparedStatement statement = con.prepareStatement("SELECT * FROM points point_id = ?;")) {
		        statement.setInt(1, point_id);
		        try (ResultSet rs = statement.executeQuery()) {
		            if (rs.next()) {
		                Points result = new Points();
		                return Optional.of(result);
		            }
		        }
		    }
		return Optional.empty();
	}

	@Override
	public Optional<List<Points>> getAll(int optional_id) throws SQLException, Exception {
		return Optional.empty();
	}

	@Override
	public void save(Points t, String[] args) throws SQLException, Exception {
		
	}

	@Override
	public void update(Points t) throws SQLException, Exception {
		
	}

	@Override
	public void delete(Points t) throws SQLException, Exception {
		
	}

}
