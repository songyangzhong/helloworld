package com.niit.service;

import java.util.List;

import com.niit.model.UserTest;

public interface IUserService {
	
     void save(UserTest u);
	 void update(UserTest u);
	 List<UserTest> findAll();
     UserTest findById(Integer id);
}
