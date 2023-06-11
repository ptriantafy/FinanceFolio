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

import com.financefolio.premiumfeatures.PremiumFeatureToken;

public class PremiumFeatureTokenDAO implements DAO<PremiumFeatureToken> {
	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public PremiumFeatureTokenDAO()
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
	public Optional<PremiumFeatureToken> get(int id) throws SQLException, Exception {
	    try (Connection con = this.connect();
		        PreparedStatement statement = con.prepareStatement("SELECT * FROM premium_feature_tokens WHERE token_id = ?;")) {
		        statement.setInt(1, id);
		        try (ResultSet rs = statement.executeQuery()) {
		            if (rs.next()) {
		                PremiumFeatureToken result = new PremiumFeatureToken(rs.getInt("token_id"), rs.getDate("received_on"), null);
		                result.fetchPremiumFeature(rs.getInt("feature_id"));
		                return Optional.of(result);
		            }
		        }
		    }
		    return Optional.empty();
	}
	@Override
	public Optional<List<PremiumFeatureToken>> getAll(int member_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM premium_feature_tokens WHERE member_id = ?;");
		statement.setInt(1, member_id);
		ResultSet rs = statement.executeQuery();
		List<PremiumFeatureToken> result = new ArrayList<>();
		while(rs.next()) {
			PremiumFeatureToken tempresult = new PremiumFeatureToken(rs.getInt("token_id"), rs.getDate("received_on"), null);
            tempresult.fetchPremiumFeature(rs.getInt("feature_id"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	requires args[0]=member_id
	@Override
	public void save(PremiumFeatureToken t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO premium_feature_tokens(received_on, member_id, feature_id) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
		statement.setDate(1, t.getReceivedOn());
		statement.setInt(2, Integer.parseInt(Objects.requireNonNull(args[0], "ID of member cannot be null")));
		statement.setInt(3, t.getTokenFor().getId());
		statement.executeUpdate();
		ResultSet newTokenId = statement.getGeneratedKeys();
		int tokenId = 0;
		if (newTokenId.next()) {
			tokenId = newTokenId.getInt(1);
		}
		t.setId(tokenId);
		con.close();
	}

	@Override
	public void update(PremiumFeatureToken t) throws SQLException, Exception {
//		unimplemented
	}

	@Override
	public void delete(PremiumFeatureToken t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM premium_feature_tokens WHERE token_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeUpdate();
		con.close();
	}

}
