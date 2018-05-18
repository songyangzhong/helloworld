package com.niit.dao.impl;

import org.springframework.stereotype.Repository;

import com.niit.dao.IPatientDao;
import com.niit.model.Patient;

@Repository
public class PatientDao extends BaseDaoImpl<Patient> implements IPatientDao{
	
}
