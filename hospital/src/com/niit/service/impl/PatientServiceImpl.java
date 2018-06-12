package com.niit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IPatientDao;
import com.niit.model.Patient;
import com.niit.model.Patient_Inspect;
import com.niit.service.IPatientService;
import com.niit.util.MD5keyBean;
import com.niit.web.form.PatientForm;

@Service
public class PatientServiceImpl implements IPatientService{
	
	@Resource
	private IPatientDao patientDao;

	@Override
	public int save(PatientForm patientForm) {
		Patient patient =  this.patientDTOTopatientVO(patientForm);
		return (int) patientDao.save(patient);
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
		Patient patient_db = patientDao.findById(patientForm.getPatientId());
		String password_db = patient_db.getPassword();
		//密码已修改
		if(!password_db.equals(patientForm.getPassword())) {
			//md5
			MD5keyBean md5keyBean = new MD5keyBean();
			Random rand = new Random();
			byte ib = (byte) rand.nextInt(128);
			String salt = MD5keyBean.byteHEX(ib);
			patientForm.setSalt(salt);
			String md5_password = md5keyBean.getkeyBeanofStr(patientForm.getPassword()+salt);
			patientForm.setPassword(md5_password);
			//
		}
		patientDao.getSession().evict(patient_db);
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
		patientForm.setInspects(patient.getInspects());
		patientForm.setSalt(patient.getSalt());
		patientForm.setDoctors(patient.getDoctors());
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
		patient.setSalt(patientForm.getSalt());
		patient.setInspects(patientForm.getInspects());
		patient.setDoctors(patientForm.getDoctors());
		return patient;
	}

	@Override
	public PatientForm login(PatientForm patientForm) {
		Patient patient = patientDao.login(patientForm);
		if(patient!=null) {
			//md5 password
			String password = patientForm.getPassword();
			String db_password = patient.getPassword();
			MD5keyBean md5keyBean = new MD5keyBean();
			String md5_password = md5keyBean.getkeyBeanofStr(password+patient.getSalt());
			//password is wrong
			if(!db_password.equals(md5_password)) {
				return null;
			}else {
				return this.patientVoTopatientDTO(patient);
			}
		}else {
			return null;
		}
	}

	@Override
	public List<Patient_Inspect> findInspectByPatientId(int patientId) {
		List<Object[]> objects = patientDao.findInspectByPatientId(patientId);
		List<Patient_Inspect> patient_Inspects = new ArrayList<>();
		Patient_Inspect patient_Inspect = null;
		for(int i=0;i<objects.size();i++) {
			Object[] Object = objects.get(i);
			patient_Inspect = new Patient_Inspect();
			patient_Inspect.setInspectId((int) Object[0]);
			patient_Inspect.setPatientId((int) Object[1]);
			patient_Inspect.setPatientName((String) Object[2]);
			patient_Inspect.setInspectName((String) Object[3]);
			patient_Inspect.setResult((String) Object[4]);
			patient_Inspects.add(patient_Inspect);
		}
		return patient_Inspects;
	}

}
