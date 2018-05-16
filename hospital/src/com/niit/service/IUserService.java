package com.niit.service;

import java.util.List;

import com.niit.model.UserTest;

public interface IUserService {
	
     void save(UserTest u);
	 void update(UserTest u);
	 void delete(Integer id);
	 List<UserTest> findAll();
     UserTest findById(Integer id);
}
