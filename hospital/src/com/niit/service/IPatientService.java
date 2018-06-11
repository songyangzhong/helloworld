package com.niit.service;

import java.util.List;

import com.niit.model.Patient;
import com.niit.model.Patient_Inspect;
import com.niit.web.form.PatientForm;

public interface IPatientService {
	public int save(PatientForm patientForm);
    public Patient findDoctorById(Integer doctorId);
    public List<Patient> findAll();
    public PatientForm findById(int patientId);
    public void deleteById(int patientId);
    public void delete(Patient patient);
    public void update(PatientForm patientForm);
	public PatientForm login(PatientForm patientForm);
	public List<Patient_Inspect> findInspectByPatientId(int patientId);
    
}
