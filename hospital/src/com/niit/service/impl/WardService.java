package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.impl.WardDao;
import com.niit.model.Ward;

@Service
public class WardService{
	
	@Resource
	private WardDao wardDao;
	
	public void save(Ward ward) {
		wardDao.save(ward);
	}
	
	public Ward findById(int id) {
		return wardDao.findById(id);
	}
	
	public List<Ward> findAll(){
		return wardDao.findAll();
	}
	
	public void delete(Ward ward) {
		wardDao.delete(ward);
	}
	
	public void update(Ward ward) {
		wardDao.update(ward);
	}

}

