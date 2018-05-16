package com.niit.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.niit.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource
	private HibernateTemplate ht;

    @Override
    public void save(T entity) {
        ht.save(entity);
    }

    @Override
    public void delete(T entity) {
        ht.delete(entity);
    }

    @Override
    public T update(T entity) {
        ht.update(entity);
        return entity;
    }

    @Override
    public void saveOrUpdate(T entity) {
        ht.saveOrUpdate(entity);
    }

}
