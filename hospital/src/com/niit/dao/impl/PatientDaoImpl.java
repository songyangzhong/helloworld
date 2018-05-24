package com.niit.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.dao.IPatientDao;
import com.niit.model.Case;
import com.niit.model.Patient;
import com.niit.util.MD5keyBean;
import com.niit.web.form.PatientForm;

@Repository
public class PatientDaoImpl extends BaseDaoImpl<Patient> implements IPatientDao{

	@Override
	public Patient login(PatientForm patientForm) {
		String patientName = patientForm.getPatientName();
		String queryString = "from " + super.getClassName() + " p where p.patientName=?";
		Object[] objects = new Object[]{patientName};
		List<Patient> patients = (List<Patient>) ht.find(queryString, objects);
		Patient patient = null;
		if(!patients.isEmpty()) {
			patient = patients.get(0);
		}
		return patient;
	}
	
}
