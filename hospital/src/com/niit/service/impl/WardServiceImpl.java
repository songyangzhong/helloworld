package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IWardDao;
import com.niit.model.Ward;
import com.niit.service.IWardService;

@Service
public class WardServiceImpl implements IWardService{
	
	@Resource
	private IWardDao wardDao;

	@Override
	public List<Ward> findAll() {
		return wardDao.findAll();
	}

	@Override
	public void deleteById(int wardId) {
		Ward ward = new Ward();
		ward.setWardId(wardId);
		wardDao.delete(ward);
	}

}
