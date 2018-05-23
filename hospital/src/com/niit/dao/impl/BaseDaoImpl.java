package com.niit.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.niit.dao.BaseDao;
import com.niit.util.GenericSuperClass;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	//范型转换
	@SuppressWarnings("unchecked")
	private Class entity = (Class)GenericSuperClass.getClass(this.getClass());
	
	@Resource
	protected HibernateTemplate ht;

	@Override
    public int save(T entity) {
        return (int)ht.save(entity);
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

	@Override
	public T findById(int id) {
		return (T)ht.get(entity, id);
	}
	
	public String getClassName() {
		//entity.toString的打印结果是  class com.niit.model.Ward
		String entityname  = entity.toString();
		String[] strings = entityname.split(" ");
		//获得com.niit.model.Ward
		String classname = strings[1];
		return classname;
	}

	@Override
	public List<T> findAll() {
		return (List<T>) ht.find("from " + getClassName());
	}

}
