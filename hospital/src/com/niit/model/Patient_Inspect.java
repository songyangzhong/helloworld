package com.niit.model;

public class Patient_Inspect {
	private int patientId;
	private int inspectId;
	private String patientName;
	private String inspectName;
	private String result;
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getInspectName() {
		return inspectName;
	}
	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getInspectId() {
		return inspectId;
	}
	public void setInspectId(int inspectId) {
		this.inspectId = inspectId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
