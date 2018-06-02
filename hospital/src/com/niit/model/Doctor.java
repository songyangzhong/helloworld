package com.niit.model;


import java.util.Collection;
import java.util.Date;

public class Doctor {
    private int doctorId;
    private int departmentId;
    private String doctorName;
    private String password;
    private String salt;
    private String gender;
    private int age;
    private String phoneNumber;
    private Date createTime;
    private Collection<Case> casesByDoctorId;
    private Department departmentByDepartmentId;
    private Collection<Register> registersByDoctorId;
    
    public Doctor() {
		super();
	}
   
	public Doctor(int doctorId) {
		super();
		this.doctorId = doctorId;
	}

	public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

	public Collection<Case> getCasesByDoctorId() {
		return casesByDoctorId;
	}

	public void setCasesByDoctorId(Collection<Case> casesByDoctorId) {
		this.casesByDoctorId = casesByDoctorId;
	}

	public Department getDepartmentByDepartmentId() {
		return departmentByDepartmentId;
	}

	public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
		this.departmentByDepartmentId = departmentByDepartmentId;
	}

	public Collection<Register> getRegistersByDoctorId() {
		return registersByDoctorId;
	}

	public void setRegistersByDoctorId(Collection<Register> registersByDoctorId) {
		this.registersByDoctorId = registersByDoctorId;
	}

}
