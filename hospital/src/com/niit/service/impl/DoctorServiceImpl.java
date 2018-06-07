package com.niit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IDoctorDao;
import com.niit.model.Doctor;
import com.niit.model.Patient;
import com.niit.service.IDoctorService;
import com.niit.util.MD5keyBean;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Resource
	private IDoctorDao doctorDao;

	@Override
	public void saveDoctor(Doctor doctor) {
		//md5
		MD5keyBean md5keyBean = new MD5keyBean();
		Random rand = new Random();
		byte ib = (byte) rand.nextInt(128);
		String salt = MD5keyBean.byteHEX(ib);
		doctor.setSalt(salt);
		String md5_password = md5keyBean.getkeyBeanofStr(doctor.getPassword()+salt);
		doctor.setPassword(md5_password);
		//
		doctor.setCreateTime(new Date());
		doctorDao.save(doctor);
	}
	
	@Override
	public Doctor findDoctorById(Integer doctorId) {
		return  doctorDao.findById(doctorId);
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
		Doctor doctor_db = findDoctorById(doctor.getDoctorId());
		String password_db = doctor_db.getPassword();
		//密码已修改
		if(!password_db.equals(doctor.getPassword())) {
			//md5
			MD5keyBean md5keyBean = new MD5keyBean();
			Random rand = new Random();
			byte ib = (byte) rand.nextInt(128);
			String salt = MD5keyBean.byteHEX(ib);
			doctor.setSalt(salt);
			String md5_password = md5keyBean.getkeyBeanofStr(doctor.getPassword()+salt);
			doctor.setPassword(md5_password);
			//
		}
		this.doctorDao.getSession().evict(doctor_db);
		doctor.setCreateTime(new Date());
		this.doctorDao.update(doctor);
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		this.doctorDao.delete(doctor);
	}

	@Override
	public Doctor login(String doctorName, String password) {
		Doctor doctor = doctorDao.findByDoctorName(doctorName);
		if(doctor!=null) {
			//md5 password
			String db_password = doctor.getPassword();
			MD5keyBean md5keyBean = new MD5keyBean();
			String md5_password = md5keyBean.getkeyBeanofStr(password+doctor.getSalt());
			//password is wrong
			if(!db_password.equals(md5_password)) {
				return null;
			}else {
				return doctor;
			}
		}else {
			return null;
		}
	}

}
