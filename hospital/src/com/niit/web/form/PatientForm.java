package com.niit.web.form;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.niit.model.Case;
import com.niit.model.Inspect;
import com.niit.model.Register;
import com.niit.model.Ward;

public class PatientForm {
	private int patientId;
	private String patientName;
	private String password;
	private Integer wardId;
	private int age;
	private String gender;
	private String dietAdvice;
	private String medicineHistory;
	private String phoneNumber;
	private Date createTime;
	private String salt;
	private Set<Inspect> inspects;

	public Set<Inspect> getInspects() {
		return inspects;
	}

	public void setInspects(Set<Inspect> inspects) {
		this.inspects = inspects;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
