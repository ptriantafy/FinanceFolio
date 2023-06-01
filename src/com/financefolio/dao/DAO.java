package com.financefolio.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	public Optional<T> get(int id, String[] params) throws SQLException, Exception;
	public Optional<List<T>> getAll(int id) throws SQLException, Exception;
    public void save(T t) throws SQLException;
    public void update(T t, String[] params) throws SQLException, Exception;
    public void delete(T t) throws SQLException, Exception;
    
    
    
    // //Definitions without the id param
	// public Optional<T> get(String[] params) throws SQLException, Exception;
	// public Optional<List<T>> getAll(String[] params) throws SQLException, Exception;
}
