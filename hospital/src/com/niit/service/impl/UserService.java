package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IUserDao;
import com.niit.model.UserTest;
import com.niit.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private IUserDao userDao;

	public void setuserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(UserTest u) {
		userDao.save(u);
	}

	@Override
	public void update(UserTest u) {
		userDao.update(u);
	}

	@Override
	public List<UserTest> findAll() {
		return userDao.findAll();
	}

	@Override
	public UserTest findById(Integer id) {
		return userDao.findById(id);
	}

}
