package com.niit.service;

import java.util.List;

import com.niit.model.Doctor;
import com.niit.model.Patient;
import com.niit.web.form.PatientForm;

public interface IPatientService {
	public void save(Patient patient);
    public Patient findDoctorById(Integer doctorId);
    public List<Patient> findAll();
    public PatientForm findById(int patientId);
    public void deleteById(int patientId);
    public void delete(Patient patient);
    public void update(PatientForm patientForm);
    
}
