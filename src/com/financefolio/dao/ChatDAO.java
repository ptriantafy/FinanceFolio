package com.financefolio.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.financefolio.social.chat.Chat;

public class ChatDAO implements DAO<Chat> {

	@Override
	public Optional<Chat> get(int id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<List<Chat>> getAll(int id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(Chat t, String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Chat t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Chat t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}



}
