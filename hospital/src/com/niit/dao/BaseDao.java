package com.niit.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	
    public int save(T entity);
    public void delete(T entity);
    public T update(T entity);
    public void saveOrUpdate(T entity);
    public T findById(int id);
    public List<T> findAll();
    public Session getSession();
    
}
