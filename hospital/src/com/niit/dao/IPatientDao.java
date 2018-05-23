package com.niit.dao;

import com.niit.model.Patient;
import com.niit.web.form.PatientForm;

public interface IPatientDao extends BaseDao<Patient>{

	Patient login(PatientForm patientForm);
		
}
