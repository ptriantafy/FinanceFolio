package com.financefolio.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	public Optional<T> get(int id);
	public List<T> getAll();
    public void save(T t);
    public void update(T t, String[] params);
    public void delete(T t);
}
