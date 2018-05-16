package com.niit.model;


import java.util.Date;

public class Register {
    private int registerId;
    private int patientId;
    private int departmentId;
    private int doctorId;
    private Date createTime;
    private int state;
    private Patient patientByPatientId;
    private Department departmentByDepartmentId;
    private Doctor doctorByDoctorId;

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

	public Patient getPatientByPatientId() {
		return patientByPatientId;
	}

	public void setPatientByPatientId(Patient patientByPatientId) {
		this.patientByPatientId = patientByPatientId;
	}

	public Department getDepartmentByDepartmentId() {
		return departmentByDepartmentId;
	}

	public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
		this.departmentByDepartmentId = departmentByDepartmentId;
	}

	public Doctor getDoctorByDoctorId() {
		return doctorByDoctorId;
	}

	public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
		this.doctorByDoctorId = doctorByDoctorId;
	}


}
