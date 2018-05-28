package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IInspectDao;
import com.niit.model.Inspect;
import com.niit.service.IInspectService;

@Service
public class InspectServiceImpl implements IInspectService{
	
	@Resource
	private IInspectDao inspectDao;

	@Override
	public List<Inspect> findAll() {
		return inspectDao.findAll();
	}

	@Override
	public Inspect findById(int inspectId) {
		return inspectDao.findById(inspectId);
	}

	@Override
	public void deleteById(int inspectId) {
		Inspect inspect = new Inspect();
		inspect.setInspectId(inspectId);
		inspectDao.delete(inspect);
	}

}
