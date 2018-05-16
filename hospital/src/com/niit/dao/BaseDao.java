package com.niit.dao;

public interface BaseDao<T> {
    public void save(T entity);
    public void delete(T entity);
    public T update(T entity);
    public void saveOrUpdate(T entity);
}
