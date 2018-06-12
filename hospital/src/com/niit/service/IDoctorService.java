package com.niit.service;

import java.util.List;

import com.niit.model.Doctor;

public interface IDoctorService {
	public Doctor saveDoctor(Doctor doctor);
    public Doctor findDoctorById(Integer doctorId);
    public List<Doctor> findAll();
    public void deleteDoctorById(Integer doctorId);
    public void deleteDoctor(Doctor doctor);
    public Doctor updateDoctor(Doctor doctor);
	public Doctor login(String doctorName, String password);
}
