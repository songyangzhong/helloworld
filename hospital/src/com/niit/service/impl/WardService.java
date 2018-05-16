package com.niit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.impl.WardDao;
import com.niit.model.Ward;

@Service
public class WardService{
	
	@Resource
	private WardDao wardDao;
	
	public void setwardDao(WardDao wardDao) {
		this.wardDao = wardDao;
	}

	public void save(Ward ward) {
		wardDao.save(ward);
	}

}

