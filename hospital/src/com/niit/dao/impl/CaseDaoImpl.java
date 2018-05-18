package com.niit.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.dao.ICaseDao;
import com.niit.model.Case;

@Repository
public class CaseDaoImpl extends BaseDaoImpl<Case> implements ICaseDao{
	
	@Override
	public List<Case> findByPatientId(int patientId) {
		String queryString = "from " + super.getClassName() + " c where c.patientId=?";
		Object[] objects = new Object[]{patientId};
		return (List<Case>) ht.find(queryString, objects);
	}

}
