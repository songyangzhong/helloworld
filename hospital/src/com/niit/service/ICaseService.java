package com.niit.service;

import java.util.List;

import com.niit.model.Case;

public interface ICaseService {
	public List<Case> findByPatientId(int patientId);
}
