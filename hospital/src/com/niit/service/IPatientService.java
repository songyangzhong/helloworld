package com.niit.service;

import java.util.List;

import com.niit.model.Doctor;
import com.niit.model.Patient;

public interface IPatientService {
	public void save(Patient patient);
    public Patient findDoctorById(Integer doctorId);
    public List<Patient> findAll();
    public Patient findById(int patientId);
    public void deleteById(int patientId);
    public void delete(Patient patient);
    public void update(Patient patient);
    
}
