package com.niit.dao;

import java.util.List;

import com.niit.model.Case;

public interface ICaseDao extends BaseDao<Case>{
	public List<Case> findByPatientId(int patientId);
}
