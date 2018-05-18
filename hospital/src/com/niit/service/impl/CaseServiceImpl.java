package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.ICaseDao;
import com.niit.model.Case;
import com.niit.service.ICaseService;

@Service
public class CaseServiceImpl implements ICaseService{
	
	@Resource
	private ICaseDao caseDao;

	@Override
	public List<Case> findByPatientId(int patientId) {
		return caseDao.findByPatientId(patientId);
	}

}
