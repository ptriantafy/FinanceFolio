package com.financefolio.dao;



import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface DAO<T> {
	public Optional<T> get(int id) throws SQLException, Exception;
	public Optional<List<T>> getAll(int optional_id) throws SQLException, Exception;
    public void save(T t, String args[]) throws SQLException, Exception;
    public void update(T t) throws SQLException, Exception;
    public void delete(T t) throws SQLException, Exception;

}
