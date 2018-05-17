package com.niit.dao;

import java.util.List;

import com.niit.model.UserTest;
public interface IUserDao {
	 
	 void save(UserTest u);
	 void update(UserTest u);
	 List<UserTest> findAll();
     UserTest findById(Integer id);
	
}

