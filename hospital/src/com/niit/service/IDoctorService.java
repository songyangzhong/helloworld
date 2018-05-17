package com.niit.service;

import java.util.List;

import com.niit.model.Doctor;

public interface IDoctorService {
	public void saveDoctor(Doctor doctor);
    public List<Doctor> findDoctorById(Integer doctorId);
    public List<Doctor> findAll();
    public void deleteDoctorById(Integer doctorId);
    public void deleteDoctor(Doctor doctor);
    public void updateDoctor(Doctor doctor);
    
}
