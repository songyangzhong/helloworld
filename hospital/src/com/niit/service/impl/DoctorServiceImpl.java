package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IDoctorDao;
import com.niit.model.Doctor;
import com.niit.service.IDoctorService;
import com.niit.util.MD5keyBean;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Resource
	private IDoctorDao doctorDao;

	@Override
	public void saveDoctor(Doctor doctor) {
		doctor.setPassword(new MD5keyBean().getkeyBeanofStr(doctor.getPassword()));
		doctorDao.save(doctor);
		
	}
	@Override
	public List<Doctor> findDoctorById(Integer doctorId) {
		return (List<Doctor>) doctorDao.findById(doctorId);
	}

	@Override
	public List<Doctor> findAll() {
		return this.doctorDao.findAll();
	}

	@Override
	public void deleteDoctorById(Integer doctorId) {
		deleteDoctor(new Doctor(doctorId));
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		this.doctorDao.update(doctor);
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		this.doctorDao.delete(doctor);
	}

}
