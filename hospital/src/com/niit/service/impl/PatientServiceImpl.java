package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IPatientDao;
import com.niit.model.Patient;
import com.niit.service.IPatientService;
import com.niit.web.form.PatientForm;

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
	public void update(PatientForm patientForm) {
		patientDao.update(patientDTOTopatientVO(patientForm));
	}

	@Override
	public PatientForm findById(int patientId) {
		return patientVoTopatientDTO(patientDao.findById(patientId));
	}
	
	public PatientForm patientVoTopatientDTO(Patient patient) {
		PatientForm patientForm = new PatientForm();
		patientForm.setAge(patient.getAge());
		patientForm.setCreateTime(patient.getCreateTime());
		patientForm.setDietAdvice(patient.getDietAdvice());
		patientForm.setGender(patient.getGender());
		patientForm.setMedicineHistory(patient.getMedicineHistory());
		patientForm.setPassword(patient.getPassword());
		patientForm.setPatientId(patient.getPatientId());
		patientForm.setPatientName(patient.getPatientName());
		patientForm.setPhoneNumber(patient.getPhoneNumber());
		patientForm.setWardId(patient.getWardId());
		return patientForm;
	}
	
	public Patient patientDTOTopatientVO(PatientForm patientForm) {
		Patient patient = new Patient();
		patient.setAge(patientForm.getAge());
		patient.setCreateTime(patientForm.getCreateTime());
		patient.setDietAdvice(patientForm.getDietAdvice());
		patient.setGender(patientForm.getGender());
		patient.setMedicineHistory(patientForm.getMedicineHistory());
		patient.setPassword(patientForm.getPassword());
		patient.setPatientId(patientForm.getPatientId());
		patient.setPatientName(patientForm.getPatientName());
		patient.setPhoneNumber(patientForm.getPhoneNumber());
		patient.setWardId(patientForm.getWardId());
		
		return patient;
	}

}
