package com.niit.model;


import java.util.Date;

public class Case {
    private int caseId;
    private int patientId;
    private int doctorId;
    private String condition;
    private Date createTime;
    private Patient patientByPatientId;
    private Doctor doctorByDoctorId;

    public Patient getPatientByPatientId() {
		return patientByPatientId;
	}

	public void setPatientByPatientId(Patient patientByPatientId) {
		this.patientByPatientId = patientByPatientId;
	}

	public Doctor getDoctorByDoctorId() {
		return doctorByDoctorId;
	}

	public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
		this.doctorByDoctorId = doctorByDoctorId;
	}

	public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
