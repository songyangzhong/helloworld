package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IPatientDao;
import com.niit.model.Patient;
import com.niit.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{
	
	@Resource
	private IPatientDao patientDao;

	@Override
	public void save(Patient patient) {
		patientDao.save(patient);
	}

	@Override
	public Patient findDoctorById(Integer doctorId) {
		return patientDao.findById(doctorId);
	}

	@Override
	public List<Patient> findAll() {
		return patientDao.findAll();
	}

	@Override
	public void deleteById(int patientId) {
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		this.delete(patient);
	}

	@Override
	public void delete(Patient patient) {
		patientDao.delete(patient);
	}

	@Override
	public void update(Patient patient) {
		patientDao.update(patient);
	}

}
