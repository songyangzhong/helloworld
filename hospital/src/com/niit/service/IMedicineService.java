package com.niit.service;

import java.util.List;

import com.niit.model.Medicine;

public interface IMedicineService {
	public List<Medicine> findAll();
	public void deleteById(int medicineId);
}
