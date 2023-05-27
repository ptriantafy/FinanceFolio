package com.financefolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		this.usrname = "Member";
		this.password = "FinFolMembUs";
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
//	fetches specific member given their id
	@Override
	public Optional<Member> get(int member_id) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM member INNER JOIN user ON member_id = user_id WHERE member_id = ?;");
		statement.setInt(1, member_id);
		ResultSet rs = statement.executeQuery();
		Member result = new Member(rs.getInt("member_id"), rs.getString("username"), rs.getBoolean("premium_member"), rs.getInt("category"),
															rs.getFloat("income"), rs.getInt("house_area"), rs.getInt("residents"), rs.getDate("register_date"));
		con.close();
		return Optional.ofNullable(result);
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
					rs.getFloat("income"), rs.getInt("house_area"), rs.getInt("residents"), rs.getDate("register_dates"));
			result.add(tempresult);
		}
		con.close();
		return Optional.ofNullable(result);
	}

//	insert a new member
	@Override
	public void save(Member t, String[] args) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("INSERT INTO user(username, register_date) VALUES (?, ?);");
		statement.setString(1, t.getName());
		statement.setDate(2, t.getRegisterDate());
		statement.executeQuery();
		ResultSet last_id = statement.getGeneratedKeys();
		t.setId(last_id.getInt(1));
		statement = con.prepareStatement("INSERT INTO member (member_id, category, income, house_area, residents, premium_user)"
				+ "VALUES (?, ?, ?, ?, ?, ?);");
		statement.setInt(1, t.getId());
		statement.setInt(2, t.getCategory());
		statement.setFloat(3, t.getIncome());
		statement.setInt(4, t.getHouseArea());
		statement.setInt(5, t.getHouseResidents());
		statement.setBoolean(6, t.isPremiumMember());
		statement.execute();
		con.close();
	}

//	edit member info
	@Override
	public void update(Member t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("UPDATE user SET username = ?;");
		statement.setString(1, t.getName());
		statement = con.prepareStatement("UPDATE member SET category = ?, income = ?, house_area = ?, residents = ?, premium_user = ?;");
		statement.setInt(1, t.getCategory());
		statement.setFloat(2, t.getIncome());
		statement.setInt(3, t.getHouseArea());
		statement.setInt(4, t.getHouseResidents());
		statement.setBoolean(5, t.isPremiumMember());
		statement.executeQuery();
		con.close();
	}

	
//	delete existing member
	@Override
	public void delete(Member t) throws SQLException, Exception {
		Connection con = this.connect();
		PreparedStatement statement = con.prepareStatement("DELETE FROM member WHERE member_id = ?;");
		statement.setInt(1, t.getId());
		statement = con.prepareStatement("DELETE FROM user WHERE user_id = ?;");
		statement.setInt(1, t.getId());
		statement.executeQuery();
		con.close();
	}

}
