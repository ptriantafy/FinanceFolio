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

import com.financefolio.premiumfeatures.PremiumFeature;

public class PremiumFeatureDAO implements DAO<PremiumFeature> {
	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public PremiumFeatureDAO()
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
	public Optional<PremiumFeature> get(int id) throws SQLException, Exception {
	    try (Connection con = this.connect();
		        PreparedStatement statement = con.prepareStatement("SELECT * FROM premium_features WHERE feature_id = ?;")) {
		        statement.setInt(1, id);
		        try (ResultSet rs = statement.executeQuery()) {
		            if (rs.next()) {
		                PremiumFeature result = new PremiumFeature(rs.getInt("feature_id"), rs.getInt("cost"), rs.getString("description"));
		                return Optional.of(result);
		            }
		        }
		    }
		    return Optional.empty();
	}
	@Override
	public Optional<List<PremiumFeature>> getAll(int optinal_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM premium_features;");
		ResultSet rs = statement.executeQuery();
		List<PremiumFeature> result = new ArrayList<>();
		while(rs.next()) {
			PremiumFeature tempresult = new PremiumFeature(rs.getInt("feature_id"), rs.getInt("cost"), rs.getString("description"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

	@Override
	public void save(PremiumFeature t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO premium_features(cost, description) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, t.getCost());
		statement.setString(2, t.getDescripiton());
		statement.executeUpdate();
		ResultSet newFeatureId = statement.getGeneratedKeys();
		int featureId = 0;
		if (newFeatureId.next()) {
			featureId = newFeatureId.getInt(1);
		}
		t.setId(featureId);
		con.close();
	}

	@Override
	public void update(PremiumFeature t, String arg[]) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE premium_features SET cost = ?, description = ? WHERE feature_id = ?;");
		statement.setInt(1, t.getCost());
		statement.setString(2, t.getDescripiton());
		statement.setInt(3, t.getId());
		statement.executeUpdate();
		con.close();
	}

	@Override
	public void delete(PremiumFeature t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM premium_features WHERE feature_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeUpdate();
		con.close();
	}

}
