package com.niit.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.dao.IDoctorDao;
import com.niit.model.Doctor;
import com.niit.model.Patient;

@Repository
public class DoctorDaoImpl extends BaseDaoImpl<Doctor> implements IDoctorDao{

	@Override
	public Doctor findByDoctorName(String doctorName) {
		String queryString = "from " + super.getClassName() + " d where d.doctorName=?";
		Object[] objects = new Object[]{doctorName};
		List<Doctor> doctors = (List<Doctor>) ht.find(queryString, objects);
		Doctor doctor = null;
		if(!doctors.isEmpty()) {
			doctor = doctors.get(0);
		}
		return doctor;
	}
	
}
