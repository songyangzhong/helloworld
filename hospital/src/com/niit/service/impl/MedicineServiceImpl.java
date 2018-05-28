package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.dao.IMedicineDao;
import com.niit.model.Medicine;
import com.niit.service.IMedicineService;

@Service
public class MedicineServiceImpl implements IMedicineService{

	@Resource
	private IMedicineDao medicineDao;
	
	@Override
	public List<Medicine> findAll() {
		return medicineDao.findAll();
	}

	@Override
	public void deleteById(int medicineId) {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(medicineId);
		medicineDao.delete(medicine);
	}

}
