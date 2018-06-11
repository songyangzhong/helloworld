package com.niit.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Patient {
	private int patientId;
	private String patientName;
	private String password;
	private String salt;
	private Integer wardId;
	private int age;
	private String gender;
	private String dietAdvice;
	private String medicineHistory;
	private String phoneNumber;
	private Date createTime;
	private Collection<Case> casesByPatientId;
	private Ward WardByWardId;
	private Collection<Register> registersByPatientId;
	private Set<Inspect> inspects = new HashSet<Inspect>();
	private Collection<Doctor> doctors;

	public Set<Inspect> getInspects() {
		return inspects;
	}

	public void setInspects(Set<Inspect> inspects) {
		this.inspects = inspects;
	}

	public Ward getWardByWardId() {
		return WardByWardId;
	}

	public void setWardByWardId(Ward wardByWardId) {
		WardByWardId = wardByWardId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	
	public Collection<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Collection<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDietAdvice() {
		return dietAdvice;
	}

	public void setDietAdvice(String dietAdvice) {
		this.dietAdvice = dietAdvice;
	}

	public String getMedicineHistory() {
		return medicineHistory;
	}

	public void setMedicineHistory(String medicineHistory) {
		this.medicineHistory = medicineHistory;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Collection<Case> getCasesByPatientId() {
		return casesByPatientId;
	}

	public void setCasesByPatientId(Collection<Case> casesByPatientId) {
		this.casesByPatientId = casesByPatientId;
	}

	public Collection<Register> getRegistersByPatientId() {
		return registersByPatientId;
	}

	public void setRegistersByPatientId(Collection<Register> registersByPatientId) {
		this.registersByPatientId = registersByPatientId;
	}

	
}
