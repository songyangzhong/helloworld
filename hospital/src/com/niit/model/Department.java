package com.niit.model;

import java.util.Collection;
import java.util.Date;

public class Department {
	private int departmentId;
	private String departmentName;
	private double registerCost;
	private int doctorId;
	private Date createTime;
	private Collection<Doctor> doctorsByDepartmentId;
	private Collection<Register> registersByDepartmentId;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public double getRegisterCost() {
		return registerCost;
	}

	public void setRegisterCost(double registerCost) {
		this.registerCost = registerCost;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Collection<Doctor> getDoctorsByDepartmentId() {
		return doctorsByDepartmentId;
	}

	public void setDoctorsByDepartmentId(Collection<Doctor> doctorsByDepartmentId) {
		this.doctorsByDepartmentId = doctorsByDepartmentId;
	}

	public Collection<Register> getRegistersByDepartmentId() {
		return registersByDepartmentId;
	}

	public void setRegistersByDepartmentId(Collection<Register> registersByDepartmentId) {
		this.registersByDepartmentId = registersByDepartmentId;
	}
}
