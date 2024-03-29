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

import com.financefolio.user.Member;

public class MemberDAO implements DAO<Member> {
	private String db_url = "jdbc:mysql://localhost:3306/financefolio";
	private String usrname;
	private String password;
	
	//constructor
	public MemberDAO()
	{
		this.usrname = "root";
        this.password = "test";
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
//	fetches specific member given their id
	@Override
	public Optional<Member> get(int member_id) throws Exception {
	    try (Connection con = this.connect();
	         PreparedStatement statement = con.prepareStatement("SELECT * FROM member INNER JOIN user ON member_id = user_id WHERE member_id = ?;")) {
	        statement.setInt(1, member_id);
	        try (ResultSet rs = statement.executeQuery()) {
	            if (rs.next()) {
	                Member result = new Member(rs.getInt("member_id"), rs.getString("username"), rs.getBoolean("premium_member"), rs.getInt("category"),
	                        rs.getFloat("income"), rs.getInt("house_area"), rs.getInt("residents"), rs.getDate("register_date"));
	                return Optional.of(result);
	            }
	        }
	    }
	    return Optional.empty();
	}
// fetches all members
	@Override
	public Optional<List<Member>> getAll(int optional_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM member INNER JOIN user ON member_id = user_id;");
		ResultSet rs = statement.executeQuery();
		List<Member> result = new ArrayList<>();
		while(rs.next()) {
			Member tempresult = new Member(rs.getInt("member_id"), rs.getString("username"), rs.getBoolean("premium_member"), rs.getInt("category"),
					rs.getFloat("income"), rs.getInt("house_area"), rs.getInt("residents"), rs.getDate("register_date"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	insert a new member
	@Override
	public void save(Member t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO user(username, register_date) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, t.getName());
		statement.setDate(2, t.getRegisterDate());
		statement.executeUpdate();
		ResultSet last_id = statement.getGeneratedKeys();
		int memberId = 0;
		if (last_id.next()) {
			memberId = last_id.getInt(1);
		}
		t.setId(memberId);
		statement = con.prepareStatement("INSERT INTO member (member_id, category, income, house_area, residents, premium_member)"
				+ "VALUES (?, ?, ?, ?, ?, ?);");
		statement.setInt(1, t.getId());
		statement.setInt(2, t.getCategory());
		statement.setFloat(3, t.getIncome());
		statement.setInt(4, t.getHouseArea());
		statement.setInt(5, t.getHouseResidents());
		statement.setBoolean(6, t.isPremiumMember());
		statement.executeUpdate();
		con.close();
	}

//	edit member info
	@Override
	public void update(Member t, String arg[]) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE user SET username = ?;");
		statement.setString(1, t.getName());
		statement = con.prepareStatement("UPDATE member SET category = ?, income = ?, house_area = ?, residents = ?, premium_member = ? WHERE member_id = ?;");
		statement.setInt(1, t.getCategory());
		statement.setFloat(2, t.getIncome());
		statement.setInt(3, t.getHouseArea());
		statement.setInt(4, t.getHouseResidents());
		statement.setBoolean(5, t.isPremiumMember());
		statement.setInt(6, t.getId());
		statement.executeUpdate();
		con.close();
	}

	
//	delete existing member
	@Override
	public void delete(Member t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM member WHERE member_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeUpdate();
		statement = con.prepareStatement("DELETE FROM user WHERE user_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeUpdate();
		con.close();
	}

}
