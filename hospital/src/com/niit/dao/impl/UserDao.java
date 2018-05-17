package com.niit.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.dao.IUserDao;
import com.niit.model.UserTest;

@Repository
public class UserDao implements IUserDao {
	
	@Resource
	private HibernateTemplate ht;

	@Override
	public void save(UserTest u) {
		ht.save(u);
	}

	@Override
	public void update(UserTest u) {
		ht.update(u);
	}

	@Override
	public List<UserTest> findAll() {
		return ht.loadAll(UserTest.class);
	}

	@Override
	public UserTest findById(Integer id) {
		return ht.get(UserTest.class, id);
	}

}
